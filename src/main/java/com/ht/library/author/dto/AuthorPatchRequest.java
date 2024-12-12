package com.ht.library.author.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorPatchRequest {
  private String name;
  private String about;
  private MultipartFile photo;
}
