package com.ht.library.user;

import com.ht.library.user.dto.UserDetailDTO;
import com.ht.library.user.dto.UserPatchRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
  private final UserService service;

  @GetMapping("/me")
  public ResponseEntity<UserDetailDTO> getUserInfo() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (!(authentication instanceof AnonymousAuthenticationToken)) {
      String currentUserName = authentication.getName();
      return ResponseEntity.ok(service.getUser(currentUserName));
    }
    throw new UsernameNotFoundException("User not found");
  }

  @PatchMapping("/me")
  public ResponseEntity<UserDetailDTO> updateUserInfo(@ModelAttribute UserPatchRequest userDto) throws IOException {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (!(authentication instanceof AnonymousAuthenticationToken)) {
      String currentUserName = authentication.getName();
      return ResponseEntity.ok(service.updateUser(currentUserName, userDto));
    }
    throw new UsernameNotFoundException("User not found");
  }

}
