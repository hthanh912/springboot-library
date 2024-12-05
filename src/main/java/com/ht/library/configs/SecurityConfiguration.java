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
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
        .csrf().and().cors()
        .disable()
        .authorizeHttpRequests()
        .requestMatchers("/auth/**").permitAll()
        .requestMatchers(HttpMethod.POST, "/books", "/authors/**").hasAnyAuthority("ADMIN")
        .requestMatchers(HttpMethod.DELETE, "/books", "/authors/**").hasAnyAuthority("ADMIN")
        .requestMatchers(HttpMethod.PATCH, "/books", "/authors/**").hasAnyAuthority("ADMIN")
        .requestMatchers(HttpMethod.POST, "/books/{id}/reviews").authenticated()
        .anyRequest()
        .permitAll()
        .and()
        .exceptionHandling()
        .authenticationEntryPoint(new Http401UnauthorizedEntryPoint())
        .accessDeniedHandler(new Http401UnauthorizedEntryPoint())
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwrAuthFilter, UsernamePasswordAuthenticationFilter.class)
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
      config.setAllowedOrigins(Collections.singletonList("*"));
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
