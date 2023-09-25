package com.ht.library.genre;

import com.ht.library.handlers.ResponseHandler;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService{

  private final GenreRepository repository;

  @Override
  public List<Genre> getAllGenre() {
    return repository.findAll();
  }
}
