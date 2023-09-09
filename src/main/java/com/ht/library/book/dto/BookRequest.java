package com.ht.library.book.dto;

import lombok.*;

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
  private UUID authorId;
}
