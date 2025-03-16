package com.ht.library.book.dto;

import com.ht.library.author.dto.AuthorResponse;
import com.ht.library.genre.dto.GenreItemResponse;

import java.util.Set;

public interface BookResponse {
  Integer getId();
  String getTitle();
  Set<GenreItemResponse> getGenres();
  Integer getRatingsCount();
  Float getAverageRating();
  Set<AuthorResponse> getAuthors();
  String getImageUrl();
}