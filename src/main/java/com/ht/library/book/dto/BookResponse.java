package com.ht.library.book.dto;
import com.ht.library.author.dto.AuthorResponse;
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
  private AuthorResponse author;
  private Integer numberOfReviews;
  private Integer numberOfRatings;
  private Float averageRate;
}