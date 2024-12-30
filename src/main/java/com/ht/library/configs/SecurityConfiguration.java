package com.ht.library.configs;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.filter.CorsFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

  private final JwtAuthenticationFilter jwrAuthFilter;
  private final AuthenticationProvider authenticationProvider;
  private final LogoutHandler logoutHandler;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
            // Disable CSRF and CORS
            .csrf().disable()
            .cors().disable()

            // First, permit all requests to /auth/**
            .authorizeHttpRequests()
            .requestMatchers("/auth/**").permitAll()

            // Then, apply role-based access control for the other paths
            .requestMatchers(HttpMethod.POST, "/books", "/authors/**").hasAuthority("ADMIN")
            .requestMatchers(HttpMethod.DELETE, "/books", "/authors/**").hasAuthority("ADMIN")
            .requestMatchers(HttpMethod.PATCH, "/books", "/authors/**").hasAuthority("ADMIN")
            .requestMatchers(HttpMethod.POST, "/books/{id}/reviews").authenticated()

            // Permit all other requests
            .anyRequest().permitAll()
            .and()

            // Set up exception handling (e.g., custom 401 error handling)
            .exceptionHandling()
            .authenticationEntryPoint(new Http401UnauthorizedEntryPoint())
            .accessDeniedHandler(new Http401UnauthorizedEntryPoint())
            .and()

            // Stateless session management
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()

            // Authentication and JWT filter
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwrAuthFilter, UsernamePasswordAuthenticationFilter.class)

            // Logout configuration
            .logout()
            .logoutUrl("/auth/logout")
            .addLogoutHandler(logoutHandler)
            .logoutSuccessHandler((request, response, authentication) -> {
              SecurityContextHolder.clearContext();
            });

    return httpSecurity.build();
  }

  @Bean
  public CorsFilter corsFilter() {
    return new CorsFilter(request -> {
      CorsConfiguration config = new CorsConfiguration();
      config.addAllowedOriginPattern("*");
      config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
      config.setAllowedHeaders(Collections.singletonList("*"));
      config.setAllowCredentials(true);
      return config;
    });
  }

  public static class Http401UnauthorizedEntryPoint implements AuthenticationEntryPoint, AccessDeniedHandler {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
      var map = new HashMap<String, Object>();
      map.put("message", "You are not authenticated.");
      map.put("status", HttpStatus.UNAUTHORIZED.value());
      var gson = new Gson();
      var responseString = gson.toJson(map);
      response.setStatus(HttpStatus.UNAUTHORIZED.value());
      response.setContentType("application/json");
      response.getWriter().write(responseString);
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
      var map = new HashMap<String, Object>();
      map.put("message", "You are not authenticated.");
      map.put("status", HttpStatus.UNAUTHORIZED.value());
      var gson = new Gson();
      var responseString = gson.toJson(map);
      response.setStatus(HttpStatus.UNAUTHORIZED.value());
      response.setContentType("application/json");
      response.getWriter().write(responseString);
    }
  }
}
