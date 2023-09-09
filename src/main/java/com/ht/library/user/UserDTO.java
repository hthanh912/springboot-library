package com.ht.library.user;

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
}
