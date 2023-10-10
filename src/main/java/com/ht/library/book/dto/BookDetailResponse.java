package com.ht.library.book.dto;

import com.ht.library.author.dto.AuthorResponse;
import com.ht.library.genre.dto.GenreItemResponse;
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
  private AuthorResponse author;
  private List<GenreItemResponse> genres;
  private Integer numberOfReviews;
  private Integer sumOfRating;
  private Date createdAt;
  private Date updatedAt;
}