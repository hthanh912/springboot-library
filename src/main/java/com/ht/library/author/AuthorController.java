package com.ht.library.author;

import com.ht.library.author.dto.AuthorDetailView;
import com.ht.library.author.dto.AuthorPatchRequest;
import com.ht.library.author.dto.AuthorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
          @PageableDefault(value = 10, page = 0) Pageable pageable,
          @RequestParam(value = "sort", defaultValue = "averageRating,desc") String[] sort
  ) {
    Pageable pagingAndSorting = PageRequest.of(
            pageable.getPageNumber(),
            pageable.getPageSize(),
            Sort.by(Sort.Order.by(sort[0]).with(Sort.Direction.fromString(sort[1]))));
    return ResponseEntity.ok(service.getAllAuthor(pagingAndSorting));
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
