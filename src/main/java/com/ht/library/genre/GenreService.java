package com.ht.library.genre;

import com.ht.library.book.dto.BookResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface GenreService {
  List<Genre> getAllGenre();
  List<BookResponse> getBookByGenreId(UUID genreId, Pageable pageable);
}
