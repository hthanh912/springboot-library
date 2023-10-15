package com.ht.library.book.dto;

import com.ht.library.author.dto.AuthorView;

import java.util.UUID;

public interface BookView {
  UUID getId();
  String getTitle();
  String getCoverUrl();
  Integer getNumberOfReviews();
  Integer getNumberOfRatings();
  Float getAverageRate();
  AuthorView getAuthor();
}
