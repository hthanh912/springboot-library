package com.ht.library.book;

import com.cloudinary.Transformation;
import com.ht.library.author.AuthorRepository;
import com.ht.library.book.dto.BookResponse;
import com.ht.library.book.dto.BookDetailResponse;
import com.ht.library.book.dto.BookRequest;
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
  public List<BookResponse> getAllBook(UUID authorId, UUID[] genreIds, Pageable pageable) {
    return bookrepository.findByQuery(authorId, genreIds, pageable)
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
  public BookResponse insertBook(BookRequest bookDTO) throws IOException {
    Book book = mapper.map(bookDTO, Book.class);
    if (!authorRepository.existsById(bookDTO.getAuthorId())) throw new ResourceNotFoundException("Author not found");
    book.setAuthor(authorRepository.getReferenceById(bookDTO.getAuthorId()));
    if (bookDTO.getCover() != null) {
      String fileName = CommonUtils.stringToSnakeCase(book.getTitle());
      String imageURL = fileUpload.uploadFile(bookDTO.getCover(), fileName, "books",
          Map.of("transformation", new Transformation().fetchFormat("auto"))
      );
      book.setCoverUrl(imageURL);
    }
    return mapper.map(bookrepository.save(book), BookResponse.class);
  }

  @Override
  public void delete(UUID id) {
    if (bookrepository.existsById(id)) {
      bookrepository.deleteById(id);
    } else throw new ResourceNotFoundException("Not found book id " + id);
  }

  @Override
  public BookResponse patch(UUID id, BookRequest bookDTO) throws IOException {
    Book book = bookrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book id " + id + "not found"));
    if (bookDTO.getTitle() != null) {
      book.setTitle(bookDTO.getTitle());
    }
    if (bookDTO.getDescription() != null) {
      book.setDescription(bookDTO.getDescription());
    }
    if (bookDTO.getPublishedDate() != null) {
      book.setPublishedDate(bookDTO.getPublishedDate());
    }
    if (bookDTO.getCover() != null) {
      String fileName = CommonUtils.stringToSnakeCase(book.getTitle());
      String imageURL = fileUpload.uploadFile(bookDTO.getCover(), fileName, "books",
          Map.of("transformation", new Transformation().fetchFormat("auto"))
      );
      book.setCoverUrl(imageURL);
    }
    return mapper.map(bookrepository.save(book), BookResponse.class);
  }
}
