package com.ht.library.author.dto;

import com.ht.library.genre.dto.GenreItemResponse;

import java.util.List;

public interface AuthorResponse {
  Integer getId();
  String getName();
  Float getAverageRating();
  List<GenreItemResponse> getGenres();
}
