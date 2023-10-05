package com.ht.library.auth;

import com.ht.library.auth.dto.AuthenticationRequest;
import com.ht.library.auth.dto.AuthenticationResponse;
import com.ht.library.auth.dto.RegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface AuthenticationService {
  AuthenticationResponse register(RegisterRequest request);
  AuthenticationResponse authenticate(AuthenticationRequest request);

  void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
