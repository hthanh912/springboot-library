package com.ht.library.user.dto;

import com.ht.library.user.Role;
import com.ht.library.user.User;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
public class UserDetailDTO {
  private String username;
  private String firstName;
  private String lastName;
  private Role role;
  private String avatarUrl;
}
