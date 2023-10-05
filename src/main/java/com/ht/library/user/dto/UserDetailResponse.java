package com.ht.library.user.dto;

import com.ht.library.user.Role;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
public class UserDetailResponse {
  private String username;
  private String firstName;
  private String lastName;
  private Role role;
  private String avatarUrl;
}
