package com.ht.library.author.dto;

import com.ht.library.genre.dto.GenreItemResponse;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface AuthorDetailResponse {
  Integer getId();
  String getName();
  LocalDateTime getBirthDate();
  LocalDateTime getDeathDate();
  String getAbout();
  List<InfluenceAuthor> getInfluences();
  Float getAverageRating();
  Set<GenreItemResponse> getGenres();
  Integer getReviewsCount();
  Integer getRatingsCount();
  String getImageUrl();
  LocalDateTime getCreatedAt();
  LocalDateTime getUpdatedAt();

  interface InfluenceAuthor {
    Integer getId();
    String getName();
  }
}