package com.ht.library.genre;

import com.ht.library.handlers.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/genres")
@RequiredArgsConstructor
public class GenreController {

  private final GenreService service;

  @GetMapping("")
  public ResponseEntity<Object> getAllGenres() {
    return ResponseHandler.generateResponse("Get genres", HttpStatus.OK, service.getAllGenre());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getBookByGenreId(@PathVariable UUID id) {
    return ResponseHandler.generateResponse("Get genres", HttpStatus.OK, service.getAllGenre());
  }
}
