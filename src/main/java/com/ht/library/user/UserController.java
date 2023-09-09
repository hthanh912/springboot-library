package com.ht.library.user;

import com.ht.library.handlers.ResponseHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
  private final UserService service;

  @GetMapping("/me")
  public ResponseEntity<Object> getUserInfo() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (!(authentication instanceof AnonymousAuthenticationToken)) {
      String currentUserName = authentication.getName();
      Optional<User> user = service.getUser(currentUserName);
      if (user.isPresent()) {
        return ResponseHandler.generateResponse("get user successful", HttpStatus.OK, new UserDetailDTO(user.get()));
      }
    }
    return ResponseHandler.generateResponse("get user fail", HttpStatus.NOT_FOUND, null);
  }
}
