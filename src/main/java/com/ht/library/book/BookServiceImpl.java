package com.ht.library.book;

import com.cloudinary.Transformation;
import com.ht.library.author.AuthorRepository;
import com.ht.library.book.dto.*;
import com.ht.library.configs.cloudinary.FileUpload;
import com.ht.library.exception.ResourceNotFoundException;
import com.ht.library.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

  private final BookRepository bookrepository;
  private final AuthorRepository authorRepository;
  private final ModelMapper mapper;
  private  final FileUpload fileUpload;

  @Override
  public List<BookResponse> getAllBook(Integer[] authorIds, String[] genreIds, Pageable pageable) {
    return bookrepository.findByQuery(authorIds, genreIds, pageable);
  }

  @Override
  public BookDetailResponse getBookById(Integer id) {
    var book = bookrepository.getBookDetailById(id);
    return book.orElse(null);
  }

  // TODO
  @Override
  public BookResponse insertBook(BookRequest bookDTO) throws IOException {
    Book book = mapper.map(bookDTO, Book.class);
    if (!authorRepository.existsById(bookDTO.getAuthorId())) throw new ResourceNotFoundException("Author not found");
//    book.setAuthor(authorRepository.getReferenceById(bookDTO.getAuthorId()));
    if (bookDTO.getCover() != null) {
      String fileName = CommonUtils.stringToSnakeCase(book.getTitle());
      String imageURL = fileUpload.uploadFile(bookDTO.getCover(), fileName, "books",
          Map.of("transformation", new Transformation().fetchFormat("auto"))
      );
//      book.setCoverUrl(imageURL);
    }
    return mapper.map(bookrepository.save(book), BookResponse.class);
  }

  // TODO
  @Override
  public Book insertBook(Book book) throws IOException {
    return bookrepository.save(book);
  }

  @Override
  public void delete(Integer id) {
    if (bookrepository.existsById(id)) {
      bookrepository.deleteById(id);
    } else throw new ResourceNotFoundException("Not found book id " + id);
  }

  // TODO
  @Override
  public BookResponse patch(Integer id, BookRequest bookDTO) throws IOException {
    Book book = bookrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book id " + id + "not found"));
    if (bookDTO.getTitle() != null) {
      book.setTitle(bookDTO.getTitle());
    }
    if (bookDTO.getDescription() != null) {
      book.setDescription(bookDTO.getDescription());
    }
    if (bookDTO.getPublishedDate() != null) {
//      book.setPublishedDate(bookDTO.getPublishedDate());
    }
    if (bookDTO.getCover() != null) {
      String fileName = CommonUtils.stringToSnakeCase(book.getTitle());
      String imageURL = fileUpload.uploadFile(bookDTO.getCover(), fileName, "books",
          Map.of("transformation", new Transformation().fetchFormat("auto"))
      );
//      book.setCoverUrl(imageURL);
    }
    return mapper.map(bookrepository.save(book), BookResponse.class);
  }
}
