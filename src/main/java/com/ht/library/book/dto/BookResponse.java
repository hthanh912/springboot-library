package com.ht.library.book.dto;

import com.ht.library.author.dto.AuthorView;
import com.ht.library.configs.cloudinary.CloudinaryConfig;
import com.ht.library.genre.dto.GenreItemResponse;
import java.util.Set;

public interface BookResponse {
  Integer getId();
  String getTitle();
  Set<GenreItemResponse> getGenres();
  Integer getRatingsCount();
  Float getAverageRating();
  Set<AuthorView> getAuthors();
  default String getImageUrl() {
    return CloudinaryConfig.getImageUrl(
            getId().toString(), CloudinaryConfig.FOLDER.books.toString(), CloudinaryConfig.SMALL_WIDTH);
  }
}