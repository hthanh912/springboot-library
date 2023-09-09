package com.ht.library.book.dto;

import com.ht.library.author.Author;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDetailResponse {
  private UUID id;
  private String title;
  private Author author;
  private Integer numberOfReviews;
  private Integer sumOfRate;
  private Date createdAt;
  private Date updatedAt;
}