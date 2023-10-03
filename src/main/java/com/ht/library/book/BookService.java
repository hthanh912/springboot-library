package com.ht.library.book;

import com.ht.library.book.dto.BookDetailResponse;
import com.ht.library.book.dto.BookRequest;
import com.ht.library.book.dto.BookResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public interface BookService {
  List<BookResponse> getAllBook(UUID authorId, UUID[] genreIds, Pageable pageable);
  BookDetailResponse getBookById(UUID id);
  List<BookResponse> getBookByAuthorId(UUID authorId);
  BookResponse insertBook(BookRequest book);
  void delete(UUID id);
  BookResponse patch(UUID id, Map<String, Object> fields);
}
