package com.ht.library.genre;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GenreService {
  List<Genre> getAllGenre();
}
