package com.ht.library.author;

import com.ht.library.author.dto.AuthorResponse;
import com.ht.library.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("authors")
@RequiredArgsConstructor
public class AuthorController {

  private final AuthorService service;

  @GetMapping("")
  public ResponseEntity<List<AuthorResponse>> getAllAuthors() {
    return ResponseEntity.ok(service.getAllAuthor());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Author> getAuthorById(@PathVariable UUID id) {
    Optional<Author> author = service.getAuthorById(id);
    if (author.isPresent()){
      return ResponseEntity.ok(author.get());
    }
    throw new ResourceNotFoundException("Author not found");
  }
}
