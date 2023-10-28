package com.ht.library.auth;

import com.ht.library.auth.dto.AuthenticationRequest;
import com.ht.library.auth.dto.AuthenticationResponse;
import com.ht.library.auth.dto.RegisterRequest;
import com.ht.library.configs.JwtService;
import com.ht.library.exception.InvalidUsernameException;
import com.ht.library.token.Token;
import com.ht.library.token.TokenRepository;
import com.ht.library.token.TokenType;
import com.ht.library.user.Role;
import com.ht.library.user.User;
import com.ht.library.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImp implements AuthenticationService{

  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  private final TokenRepository tokenRepository;

  @Override
  public AuthenticationResponse register(RegisterRequest request) {
    if (repository.findByUsername(request.getUsername()).isPresent()) {
      throw new InvalidUsernameException("Invalid Username");
    }
    var user = User.builder()
        .username(request.getUsername())
        .password(passwordEncoder.encode(request.getPassword()))
        .firstName(request.getFirstname())
        .lastName(request.getLastname())
        .role(Role.USER)
        .build();
    repository.save(user);
    var jwtToken = jwtService.generateToken(user);
    var refreshToken = jwtService.generateRefreshToken(user);
    saveUserToken(user, jwtToken, refreshToken);
    return AuthenticationResponse.builder()
        .accessToken(jwtToken)
        .refreshToken(refreshToken)
        .build();
  }

  @Override
  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getUsername(),
            request.getPassword()
        ));
    var user = repository.findByUsername(request.getUsername())
        .orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    var refreshToken = jwtService.generateRefreshToken(user);
    revokeAllUserTokens(user);
    saveUserToken(user, jwtToken, refreshToken);
    return AuthenticationResponse.builder()
        .accessToken(jwtToken)
        .refreshToken(refreshToken)
        .build();
  }

  @Override
  public AuthenticationResponse refreshToken(
      HttpServletRequest request
  ) {
    final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
    final String refreshToken;
    final String username;
    if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
      return null;
    }
    refreshToken = authHeader.substring(7);
    username = jwtService.extractUsername(refreshToken);
    if (username != null) {
      var user = this.repository.findByUsername(username)
          .orElseThrow();
      if (!jwtService.isRefreshTokenExpired(refreshToken)) {
        var accessToken = jwtService.generateToken(user);
        var newRefreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, accessToken, newRefreshToken);
        return AuthenticationResponse.builder()
            .accessToken(accessToken)
            .refreshToken(newRefreshToken)
            .build();
      }
    }
    return null;
  }

  private void saveUserToken(User user, String jwtToken, String refreshToken) {
    var token = Token.builder()
        .user(user)
        .token(jwtToken)
        .refreshToken(refreshToken)
        .tokenType(TokenType.BEARER)
        .expired(false)
        .revoked(false)
        .build();
    tokenRepository.save(token);
  }

  private void revokeAllUserTokens(User user) {
    var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
    if (validUserTokens.isEmpty())
      return;
    validUserTokens.forEach(token -> {
      token.setExpired(true);
      token.setRevoked(true);
    });
    tokenRepository.saveAll(validUserTokens);
  }
}
