package com.ht.library.user;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
public class UserDetailDTO {
  private String username;
  private String firstName;
  private String lastName;
  private Role role;

  public UserDetailDTO(User user) {
    this.username = user.getUsername();
    this.firstName = user.getFirstName();
    this.lastName = user.getLastName();
    this.role = user.getRole();
  }
}
