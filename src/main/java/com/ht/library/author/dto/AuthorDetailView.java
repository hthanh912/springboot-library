package com.ht.library.author.dto;

import com.ht.library.genre.dto.GenreItemResponse;
import java.time.LocalDateTime;
import java.util.List;

public interface AuthorDetailView {
  Integer getId();
  String getName();
  String getGoodreadUrl();
  LocalDateTime getBirthDate();
  LocalDateTime getDeathDate();
  String getAbout();
  List<InfluenceAuthor> getInfluences();
  Float getAverageRating();
  List<GenreItemResponse> getGenres();
  Integer getReviewsCount();
  Integer getRatingsCount();
  LocalDateTime getCreatedAt();
  LocalDateTime getUpdatedAt();

  interface InfluenceAuthor {
    Integer getId();
    String getName();
  }
}