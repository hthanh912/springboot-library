package com.ht.library.book.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BookRequest {
  private UUID id;
  private String title;
  private String description;
  private MultipartFile cover;
  private Integer authorId;
  private LocalDate publishedDate;
}
