package com.ht.library.book.dto;

import com.ht.library.author.Author;
import com.ht.library.genre.Genre;
import lombok.*;

import java.util.Date;
import java.util.List;
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
  private List<Genre> genres;
  private Integer numberOfReviews;
  private Integer sumOfRate;
  private Date createdAt;
  private Date updatedAt;
}