package com.ht.library.book;

import com.ht.library.book.dto.BookDetailResponse;
import com.ht.library.book.dto.BookRequest;
import com.ht.library.book.dto.BookResponse;
import com.ht.library.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

  private final BookService bookService;

  @GetMapping("")
  public ResponseEntity<List<BookResponse>> getBooks(
      @RequestParam(value = "authorId", required = false, defaultValue = "00000000-0000-0000-0000-000000000000") UUID authorId,
      @RequestParam(value = "genreIds", required = false, defaultValue = "") UUID[] genreIds,
      @PageableDefault(value = 2, page = 0) Pageable pageable
  ) {
    return new ResponseEntity<>(bookService.getAllBook(authorId, genreIds, pageable), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<BookDetailResponse> getBookById(@PathVariable UUID id) {
    var book = bookService.getBookById(id);
    if (book != null) {
      return new ResponseEntity<>(book, HttpStatus.OK);
    }
    throw new ResourceNotFoundException("Book not found.");
  }

  @GetMapping("/author/{authorId}")
  public ResponseEntity<List<BookResponse>> getBookByAuthorId(@PathVariable UUID authorId) {
    var book = bookService.getBookByAuthorId(authorId);
    if (book != null) {
      return new ResponseEntity<>(book, HttpStatus.OK);
    }
    throw new ResourceNotFoundException("Book not found.");
  }

  @PostMapping("")
  public ResponseEntity<BookResponse> insertBook(@ModelAttribute BookRequest bookDto) throws IOException {
    var insertedBook = bookService.insertBook(bookDto);
    return new ResponseEntity<>(insertedBook, HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteBook(@PathVariable UUID id) {
    bookService.delete(id);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<BookResponse> patch(@PathVariable UUID id, @ModelAttribute BookRequest bookDto) throws IOException {
    var book = bookService.patch(id, bookDto);
    return new ResponseEntity<>(book, HttpStatus.OK);
  }
}
