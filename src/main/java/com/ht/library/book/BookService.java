package com.ht.library.book;

import com.ht.library.book.dto.BookDetailResponse;
import com.ht.library.book.dto.BookRequest;
import com.ht.library.book.dto.BookResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public interface BookService {
  List<BookResponse> getAllBook(UUID authorId, UUID[] genreIds, Pageable pageable);
  BookDetailResponse getBookById(UUID id);
  BookResponse insertBook(BookRequest book) throws IOException;
  void delete(UUID id);
  BookResponse patch(UUID id, BookRequest bookDto) throws IOException;
}
