package com.ht.library.book;

import com.cloudinary.Transformation;
import com.ht.library.author.AuthorRepository;
import com.ht.library.author.dto.AuthorResponseImpl;
import com.ht.library.award.dto.BookDetailAwardImpl;
import com.ht.library.book.dto.*;
import com.ht.library.configs.cloudinary.FileUpload;
import com.ht.library.exception.ResourceNotFoundException;
import com.ht.library.genre.dto.GenreItemResponseImpl;
import com.ht.library.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

  private final BookRepository bookrepository;
  private final AuthorRepository authorRepository;
  private final ModelMapper mapper;
  private  final FileUpload fileUpload;

  @Override
  @Cacheable(value = "books", key = "(#authorIds.length != 0 ? T(java.util.Arrays).toString(#authorIds) : '') + ':' + " +
          "(#genreIds.length != 0 ? T(java.util.Arrays).toString(#genreIds) : '') + ':' + " +
          "#pageable.pageNumber + ':' + #pageable.pageSize + ':' + #pageable.sort.toString()")
  public List<BookResponseImpl> getAllBook(Integer[] authorIds, String[] genreIds, Pageable pageable) {
    var books = bookrepository.findByQuery(authorIds, genreIds, pageable);
    return books.stream().map(item ->
       new BookResponseImpl(
               item.getId(),
               item.getTitle(),
               item.getGenres().stream().map(genre -> new GenreItemResponseImpl(
                      genre.getId(),
                      genre.getName())).collect(Collectors.toSet()),
               item.getRatingsCount(), item.getAverageRating(),
               item.getAuthors().stream().map(author -> new AuthorResponseImpl(
                      author.getId(),
                      author.getName())
               ).collect(Collectors.toSet()))
    ).toList();
  }

  @Override
  @Cacheable(value = "bookDetail", key = "#id")
  public BookDetailResponseImpl getBookById(Integer id) {
    var book = bookrepository.getBookDetailById(id);
    return book.map(bookDetail -> BookDetailResponseImpl.builder()
                    .id(bookDetail.getId())
                    .title(bookDetail.getTitle())
                    .titleComplete(bookDetail.getTitleComplete())
                    .description(bookDetail.getDescription())
                    .genres(bookDetail.getGenres().stream().map(
                            genre -> new GenreItemResponseImpl(genre.getId(), genre.getName())).collect(Collectors.toSet()))
                    .asin(bookDetail.getAsin())
                    .isbn(bookDetail.getIsbn())
                    .isbn13(bookDetail.getIsbn13())
                    .publisher(bookDetail.getPublisher())
                    .series(bookDetail.getSeries())
                    .authors(bookDetail.getAuthors().stream().map(
                            author -> new AuthorResponseImpl(author.getId(), author.getName())
                    ).collect(Collectors.toSet()))
                    .publishDate(bookDetail.getPublishDate())
                    .characters(bookDetail.getCharacters())
                    .places(bookDetail.getPlaces())
                    .ratingHistogram(bookDetail.getRatingHistogram())
                    .averageRating(bookDetail.getAverageRating())
                    .ratingsCount(bookDetail.getRatingsCount())
                    .reviewsCount(bookDetail.getReviewsCount())
                    .numPages(bookDetail.getNumPages())
                    .language(bookDetail.getLanguage())
                    .awards(bookDetail.getAwards().stream().map(
                            award -> new BookDetailAwardImpl(
                                    award.getId(),
                                    award.getName(),
                                    award.getDesignation(),
                                    award.getAwardedAt(),
                                    award.getCategory())
                    ).collect(Collectors.toSet()))
                    .build())
            .orElse(null);
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
