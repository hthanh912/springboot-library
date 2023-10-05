package com.ht.library.user.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
  private String id;
  private String firstName;
  private String lastName;
  private String avatarUrl;
}
