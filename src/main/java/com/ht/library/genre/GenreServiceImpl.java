package com.ht.library.genre;

import com.ht.library.book.BookService;
import com.ht.library.book.dto.BookResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService{

  private final GenreRepository repository;
  private final BookService bookService;

  @Override
  public List<Genre> getAllGenre() {
    return repository.findAll();
  }

  @Override
  public List<BookResponse> getBookByGenreId(String genreId, Pageable pageable) {
//    return bookService.getAllBook(UUID.fromString("00000000-0000-0000-0000-000000000000"), new String[]{genreId}, pageable);
    return null;
  }

  @Override
  public Boolean isGenreExistById(String id) {
    return repository.existsById(id);
  }

  @Override
  public Genre insertGenre(Genre genre) {
    return repository.save(genre);
  }

  @Override
  public Optional<Genre> findByName(String name) {
    return Optional.ofNullable(repository.findGenreByName(name));
  }

}
