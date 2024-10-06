package com.ht.library.author;

import com.cloudinary.Transformation;
import com.ht.library.author.dto.AuthorDetailResponse;
import com.ht.library.author.dto.AuthorPatchRequest;
import com.ht.library.author.dto.AuthorResponse;
import com.ht.library.configs.cloudinary.FileUpload;
import com.ht.library.exception.ResourceNotFoundException;
import com.ht.library.genre.Genre;
import com.ht.library.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

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
  public AuthorDetailResponse getAuthorById(Integer id) {
    return mapper.map(repository.findAuthorDetailById(id), AuthorDetailResponse.class);
  }

  @Override
  public Optional<Author> getAuthorEntityById(Integer id) {
    return repository.findById(id);
  }

  @Override
  public Author updateAuthor(Integer id, AuthorPatchRequest authorDto) throws IOException {
    Author author = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author not found"));
    if (authorDto.getName() != null) {
      author.setName(authorDto.getName());
    }
    if (authorDto.getAbout() != null) {
      author.setAbout(authorDto.getAbout());
    }
    if (authorDto.getPhoto() != null) {
      String fileName = CommonUtils.stringToSnakeCase(author.getName());
      String imageURL = fileUpload.uploadFile(authorDto.getPhoto(), fileName, "authors",
          Map.of("transformation",
              new Transformation().width(500).height(500).crop("fill").fetchFormat("auto"))
      );
      author.setImageUrl(imageURL);
    }
    return mapper.map(repository.save(author), Author.class);
  }

  @Override
  public Author insertAuthor(Author author) {
    return repository.save(author);
  }

  @Override
  public Author addGenreToAuthor(Integer authorId, Genre genre) {
    Author author = repository.findById(authorId)
            .orElseThrow(() -> new RuntimeException("Author not found"));

    author.addGenre(genre);
    return repository.save(author); //
  }

}
