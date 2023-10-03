package com.ht.library.genre;

import com.ht.library.book.dto.BookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/genres")
@RequiredArgsConstructor
public class GenreController {

  private final GenreService service;

  @GetMapping("")
  public ResponseEntity<List<Genre>> getAllGenres() {
    return ResponseEntity.ok(service.getAllGenre());
  }

  @GetMapping("/{id}")
  public ResponseEntity<List<BookResponse>> getBookByGenreId(
      @PathVariable UUID id,
      @PageableDefault(value = 2, page = 0) Pageable pageable)
  {
    return ResponseEntity.ok(service.getBookByGenreId(id, pageable));
  }
}
