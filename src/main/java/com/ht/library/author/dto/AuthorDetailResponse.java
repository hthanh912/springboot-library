package com.ht.library.author.dto;

import com.ht.library.genre.dto.GenreItemResponse;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDetailResponse {
  private UUID id;
  private String name;
  private String description;
  private String born;
  private String photoUrl;
  private Integer numberOfReviews;
  private Integer numberOfRatings;
  private Float averageRate;
  private List<GenreItemResponse> genres;
  private Date createdAt;
  private Date updatedAt;
}
