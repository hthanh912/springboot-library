package com.ht.library.author.dto;

import com.ht.library.genre.dto.GenreItemView;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface AuthorDetailView {
  UUID getId();
  String getName();
  String getAbout();
  String getBorn();
  String getImageUrl();
  Integer getNumberOfReviews();
  Integer getNumberOfRatings();
  Float getAverageRate();
  List<GenreItemView> getGenres();
  Date getCreatedAt();
  Date getUpdatedAt();
}
