package com.ht.library.author;

import com.ht.library.author.dto.AuthorPatchRequest;
import com.ht.library.author.dto.AuthorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
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
    return ResponseEntity.ok(service.getAuthorById(id));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Author> updateAuthor(@PathVariable UUID id, @ModelAttribute AuthorPatchRequest authorDto) throws IOException {
    return ResponseEntity.ok(service.updateAuthor(id, authorDto));
  }
}
