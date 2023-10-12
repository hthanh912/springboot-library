package com.ht.library.author;

import com.cloudinary.Transformation;
import com.ht.library.author.dto.AuthorDetailResponse;
import com.ht.library.author.dto.AuthorPatchRequest;
import com.ht.library.author.dto.AuthorResponse;
import com.ht.library.book.Book;
import com.ht.library.configs.cloudinary.FileUpload;
import com.ht.library.exception.ResourceNotFoundException;
import com.ht.library.genre.dto.GenreItemResponse;
import com.ht.library.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService{

  private final ModelMapper mapper;

  private final AuthorRepository repository;
  private final FileUpload fileUpload;

  @Override
  public List<AuthorResponse> getAllAuthor() {
    return repository
        .findAll()
        .stream()
        .map(e -> mapper.map(e, AuthorResponse.class))
        .toList();
  }

  @Override
  public AuthorDetailResponse getAuthorById(UUID id) {
    Author author = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author not found"));
    int numberOfReviews = 0;
    int numberOfRatings = 0;
    float sumOfRatings = 0F;
    List<GenreItemResponse> genres = new ArrayList<>();
    for (Book book: author.getBooks()) {
      numberOfReviews += book.getNumberOfReviews();
      numberOfRatings += book.getNumberOfRatings();
      sumOfRatings += book.getNumberOfRatings() * book.getAverageRate();
      genres.addAll(book.getGenres().stream().map(genre -> mapper.map(genre, GenreItemResponse.class)).toList());
    }
    AuthorDetailResponse authorDetailResponse = mapper.map(author, AuthorDetailResponse.class);
    authorDetailResponse.setNumberOfReviews(numberOfReviews);
    authorDetailResponse.setNumberOfRating(numberOfRatings);
    authorDetailResponse.setAverageRate(sumOfRatings / numberOfRatings);
    authorDetailResponse.setGenres(genres);
    return authorDetailResponse;
  }

  @Override
  public Author updateAuthor(UUID id, AuthorPatchRequest authorDto) throws IOException {
    Author author = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author not found"));
    if (authorDto.getName() != null) {
      author.setName(authorDto.getName());
    }
    if (authorDto.getDescription() != null) {
      author.setDescription(authorDto.getDescription());
    }
    if (authorDto.getPhoto() != null) {
      String fileName = CommonUtils.stringToSnakeCase(author.getName());
      String imageURL = fileUpload.uploadFile(authorDto.getPhoto(), fileName, "authors",
          Map.of("transformation",
              new Transformation().width(500).height(500).crop("fill").fetchFormat("auto"))
      );
      author.setPhotoUrl(imageURL);
    }
    return mapper.map(repository.save(author), Author.class);
  }
}
