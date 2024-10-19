package com.ht.library.author;

import com.ht.library.author.dto.AuthorDetailView;
import com.ht.library.author.dto.AuthorPatchRequest;
import com.ht.library.author.dto.AuthorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("authors")
@RequiredArgsConstructor
public class AuthorController {

  private final AuthorService service;

  @GetMapping("")
  public ResponseEntity<List<AuthorResponse>> getAllAuthors(
          @RequestParam(defaultValue = "0") int page,
          @RequestParam(defaultValue = "10") int size) {
    Pageable pageable = PageRequest.of(page, size);
    return ResponseEntity.ok(service.getAllAuthor(pageable));
  }

  @GetMapping("/{id}")
  public ResponseEntity<AuthorDetailView> getAuthorById(@PathVariable Integer id) {
    return ResponseEntity.ok(service.getAuthorById(id));
  }

  // TODO: to be updated
  @PatchMapping("/{id}")
  public ResponseEntity<Author> updateAuthor(@PathVariable Integer id, @ModelAttribute AuthorPatchRequest authorDto) throws IOException {
    return ResponseEntity.ok(service.updateAuthor(id, authorDto));
  }
}
