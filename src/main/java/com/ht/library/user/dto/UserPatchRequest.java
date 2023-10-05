package com.ht.library.user.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserPatchRequest {
  private String firstName;
  private String lastName;
  private MultipartFile avatar;
}
