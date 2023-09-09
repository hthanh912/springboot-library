package com.ht.library.book.dto;
import lombok.*;

import java.util.UUID;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
  private UUID id;
  private String title;
  private String author;
  private Integer numberOfReviews;
  private Integer sumOfRate;
}