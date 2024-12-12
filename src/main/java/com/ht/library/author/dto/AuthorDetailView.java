package com.ht.library.author.dto;

import com.ht.library.configs.cloudinary.CloudinaryConfig;
import com.ht.library.genre.dto.GenreItemResponse;
import java.time.LocalDateTime;
import java.util.List;

public interface AuthorDetailView {
  Integer getId();
  String getName();
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
  default String getImageUrl() {
    return CloudinaryConfig.getImageUrl(
            getId().toString(), CloudinaryConfig.FOLDER.authors.toString(), CloudinaryConfig.MEDIUM_WIDTH);
  };

  interface InfluenceAuthor {
    Integer getId();
    String getName();
  }
}