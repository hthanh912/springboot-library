package com.ht.library.book.dto;

import com.ht.library.author.dto.AuthorResponse;
import com.ht.library.genre.dto.GenreItemResponse;
import lombok.*;

import java.time.LocalDate;
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
  private String description;
  private String coverUrl;
  private LocalDate publishedDate;
  private AuthorResponse author;
  private List<GenreItemResponse> genres;
  private Integer numberOfReviews;
  private Integer numberOfRatings;
  private Float averageRate;
  private Date createdAt;
  private Date updatedAt;
}