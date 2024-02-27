package com.ht.library.configs;

import com.google.gson.Gson;
import com.ht.library.token.TokenRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutHandler {

  private final TokenRepository tokenRepository;

  @Override
  public void logout(
      HttpServletRequest request,
      HttpServletResponse response,
      Authentication authentication
  ) {
    final String authHeader = request.getHeader("Authorization");
    System.out.println("authHeader: " + authHeader);
    final String jwt;
    if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
      return;
    }
    jwt = authHeader.substring(7);
    var storedToken = tokenRepository.findByToken(jwt)
        .orElse(null);

    var map = new HashMap<String, Object>();
    if (storedToken != null) {
      storedToken.setExpired(true);
      storedToken.setRevoked(true);
      tokenRepository.save(storedToken);
      SecurityContextHolder.clearContext();
      map.put("message", "Logout successfully");
      map.put("status", HttpStatus.OK.value());
    } else {
      response.setStatus(HttpStatus.BAD_REQUEST.value());
      map.put("message", "Token not found");
      map.put("status", HttpStatus.BAD_REQUEST.value());
    }
    var gson = new Gson();
    var responseString = gson.toJson(map);
    response.setContentType("application/json");
    try {
      response.getWriter().write(responseString);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}