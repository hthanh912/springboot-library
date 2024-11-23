package com.ht.library.book;

import com.ht.library.book.dto.*;
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

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

  private final BookService bookService;

  @GetMapping("")
  public ResponseEntity<List<BookResponse>> getBooks(
      @RequestParam(value = "authorIds", required = false) Integer[] authorIds,
      @RequestParam(value = "genreIds", required = false, defaultValue = "") String[] genreIds,
      @PageableDefault(value = 10, page = 0) Pageable pageable
  ) {
    if (authorIds == null || authorIds.length == 0) {
      authorIds = new Integer[0]; // Assign an empty array if no ids are provided
    }
    return new ResponseEntity<>(bookService.getAllBook(authorIds, genreIds, pageable), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<BookDetailResponse> getBookById(@PathVariable Integer id) {
    var book = bookService.getBookById(id);
    if (book != null) {
      return new ResponseEntity<>(book, HttpStatus.OK);
    }
    throw new ResourceNotFoundException("Book not found.");
  }

  @GetMapping("/author/{authorId}")
  public ResponseEntity<List<BookResponse>> getBookByAuthorId(
      @PathVariable Integer authorId,
      @PageableDefault(value = 10, page = 0) Pageable pageable) {
    return new ResponseEntity<>(bookService.getAllBook(new Integer[]{authorId}, new String[0], pageable), HttpStatus.OK);
  }

  // TODO:
  @PostMapping("")
  public ResponseEntity<BookResponse> insertBook(@ModelAttribute BookRequest bookDto) throws IOException {
    var insertedBook = bookService.insertBook(bookDto);
    return new ResponseEntity<>(insertedBook, HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteBook(@PathVariable Integer id) {
    bookService.delete(id);
  }

  // TODO:
  @PatchMapping("/{id}")
  public ResponseEntity<BookResponse> patch(@PathVariable Integer id, @ModelAttribute BookRequest bookDto) throws IOException {
    var book = bookService.patch(id, bookDto);
    return new ResponseEntity<>(book, HttpStatus.OK);
  }
}
