package com.ht.library.book;

import com.ht.library.book.dto.BookRequest;
import com.ht.library.exception.ResourceNotFoundException;
import com.ht.library.handlers.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

  private final BookService bookService;

  @GetMapping("")
  public ResponseEntity<Object> getBooks(
      @RequestParam(value = "authorId", required = false, defaultValue = "00000000-0000-0000-0000-000000000000") UUID authorId,
      @RequestParam(value = "genreIds", required = false, defaultValue = "") UUID[] genreIds,
      @PageableDefault(value = 2, page = 0) Pageable pageable
  ) {
    return ResponseHandler.generateResponse("Get books", HttpStatus.OK, bookService.getAllBook(authorId, genreIds, pageable));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getBookById(@PathVariable UUID id) {
    var book = bookService.getBookById(id);
    if (book != null) {
      return ResponseHandler.generateResponse("Get book successfully.", HttpStatus.OK, book);
    }
    throw new ResourceNotFoundException("Book not found.");
  }

  @GetMapping("/author/{authorId}")
  public ResponseEntity<Object> getBookByAuthorId(@PathVariable UUID authorId) {
    var book = bookService.getBookByAuthorId(authorId);
    if (book != null) {
      return ResponseHandler.generateResponse("Get book successfully.", HttpStatus.OK, book);
    }
    throw new ResourceNotFoundException("Book not found.");
  }

  @PostMapping("")
  public ResponseEntity<Object> insertBook(@RequestBody BookRequest book) {
    var insertedBook = bookService.insertBook(book);
    return ResponseHandler.generateResponse("Inserted book.", HttpStatus.OK, insertedBook);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteBook(@PathVariable UUID id) {
    bookService.delete(id);
    return ResponseHandler.generateResponse("Deleted book id " + id + ".", HttpStatus.OK, null);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Object> patch(@PathVariable UUID id, @RequestBody Map<String, Object> fields) {
    Book book = bookService.patch(id, fields);
    return ResponseHandler.generateResponse("Updated book id " + id + ".", HttpStatus.OK, book);
  }
}
