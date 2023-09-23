package com.ht.library.book;

import com.ht.library.author.Author;
import com.ht.library.author.AuthorService;
import com.ht.library.book.dto.BookDetailResponse;
import com.ht.library.book.dto.BookRequest;
import com.ht.library.book.dto.BookResponse;
import com.ht.library.exception.ResourceNotFoundException;
import com.ht.library.utils.DateTimeUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

  private final BookRepository bookrepository;
  private final AuthorService authorService;
  private final ModelMapper mapper;

  @Override
  public List<BookResponse> getAllBook(Pageable pageable) {
    return bookrepository.findAll(pageable)
        .stream()
        .map(book -> mapper.map(book, BookResponse.class))
        .toList();
  }

  @Override
  public BookDetailResponse getBookById(UUID id) {
    var book = bookrepository.findById(id);
    if (book.isPresent()) {
      return mapper.map(book.get(), BookDetailResponse.class);
    }
    return null;
  }

  @Override
  public List<BookResponse> getBookByAuthorId(UUID authorId) {
    return bookrepository.findAllByAuthorId(authorId)
            .stream()
            .map(book -> mapper.map(book, BookResponse.class))
            .toList();
  }

  @Override
  public Book insertBook(BookRequest bookDTO) {
    Book book = mapper.map(bookDTO, Book.class);
    Optional<Author> author = authorService.getAuthorById(bookDTO.getAuthorId());
    if (author.isPresent()) {
      book.setAuthor(author.get());
    }
    return bookrepository.save(book);
  }

  @Override
  public void delete(UUID id) {
    if (bookrepository.existsById(id)) {
      bookrepository.deleteById(id);
    } else throw new ResourceNotFoundException("Not found book id " + id);
  }

  @Override
  public Book patch(UUID id, Map<String, Object> fields) {
    Book book = bookrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book id " + id + "not found"));
    fields.forEach((key, value) -> {
      Field field = ReflectionUtils.findField(Book.class, key);
      if (field != null) {
        field.setAccessible(true);
        if (field.getType() == Date.class) {

          try {
            ReflectionUtils.setField(field, book, DateTimeUtils.dateFromString(value.toString()));
          } catch (ParseException e) {
            throw new RuntimeException(e);
          }
        } else {
          ReflectionUtils.setField(field, book, value);
        }
      }
    });
    return bookrepository.save(book);
  }
}
