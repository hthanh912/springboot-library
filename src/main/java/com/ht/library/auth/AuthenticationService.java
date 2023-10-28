package com.ht.library.auth;

import com.ht.library.auth.dto.AuthenticationRequest;
import com.ht.library.auth.dto.AuthenticationResponse;
import com.ht.library.auth.dto.RegisterRequest;
import jakarta.servlet.http.HttpServletRequest;

public interface AuthenticationService {
  AuthenticationResponse register(RegisterRequest request);
  AuthenticationResponse authenticate(AuthenticationRequest request);

  AuthenticationResponse refreshToken(HttpServletRequest request);
}
