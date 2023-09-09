package com.ht.library.author;

import com.ht.library.exception.ResourceNotFoundException;
import com.ht.library.handlers.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("authors")
@RequiredArgsConstructor
public class AuthorController {

  private final AuthorService service;

  @GetMapping("")
  public ResponseEntity<Object> getAllAuthors() {
    return ResponseHandler.generateResponse("get authors", HttpStatus.OK, service.getAllAuthor());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getAuthorById(@PathVariable UUID id) {
    Optional<Author> author = service.getAuthorById(id);
    if (author.isPresent()){
      return ResponseHandler.generateResponse("get author", HttpStatus.OK, author);
    }
    throw new ResourceNotFoundException("Author not found");
  }
}
