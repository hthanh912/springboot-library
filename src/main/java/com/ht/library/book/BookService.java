package com.ht.library.book;

import com.ht.library.book.dto.*;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface BookService {
  List<BookResponse> getAllBook(Integer[] authorIds, String[] genreIds, Pageable pageable);
  BookDetailResponse getBookById(Integer id);
  BookResponse insertBook(BookRequest book) throws IOException;
  Book insertBook(Book book) throws IOException;
  void delete(Integer id);
  BookResponse patch(Integer id, BookRequest bookDto) throws IOException;
}
