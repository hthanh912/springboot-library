package com.ht.library.author;

import com.cloudinary.Transformation;
import com.ht.library.author.dto.AuthorDetailResponse;
import com.ht.library.author.dto.AuthorPatchRequest;
import com.ht.library.author.dto.AuthorResponse;
import com.ht.library.book.Book;
import com.ht.library.configs.cloudinary.FileUpload;
import com.ht.library.exception.ResourceNotFoundException;
import com.ht.library.genre.Genre;
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
        .collect(Collectors.toList());
  }

  @Override
  public AuthorDetailResponse getAuthorById(UUID id) {
    Author author = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author not found"));
    int numberOfReview = 0;
    int sumOfRatings = 0;
    List<Genre> genres = new ArrayList<>();
    for (Book book: author.getBooks()) {
      numberOfReview += book.getNumberOfReviews();
      sumOfRatings += book.getSumOfRatings();
      genres.addAll(book.getGenres());
    }
    AuthorDetailResponse authorDetailResponse = mapper.map(author, AuthorDetailResponse.class);
    authorDetailResponse.setNumberOfReview(numberOfReview);
    authorDetailResponse.setSumOfRatings(sumOfRatings);
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
