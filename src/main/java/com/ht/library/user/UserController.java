package com.ht.library.user;

import com.ht.library.user.dto.UserDetailResponse;
import com.ht.library.user.dto.UserPatchRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
  private final UserService service;

  @GetMapping("/me")
  public ResponseEntity<UserDetailResponse> getUserInfo() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (!(authentication instanceof AnonymousAuthenticationToken)) {
      String currentUserName = authentication.getName();
      return ResponseEntity.ok(service.getUser(currentUserName));
    }
    throw new UsernameNotFoundException("User not found");
  }

  @PatchMapping("/me")
  public ResponseEntity<UserDetailResponse> updateUserInfo(@ModelAttribute UserPatchRequest userDto) throws IOException {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (!(authentication instanceof AnonymousAuthenticationToken)) {
      String currentUserName = authentication.getName();
      return ResponseEntity.ok(service.updateUser(currentUserName, userDto));
    }
    throw new UsernameNotFoundException("User not found");
  }

}
