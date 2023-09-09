package com.ht.library.author;

import com.ht.library.author.dto.AuthorResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService{

  private final ModelMapper mapper;

  private final AuthorRepository repository;

  @Override
  public List<AuthorResponse> getAllAuthor() {
    return repository
        .findAll()
        .stream()
        .map(e -> mapper.map(e, AuthorResponse.class))
        .collect(Collectors.toList());
  }

  @Override
  public Optional<Author> getAuthorById(UUID id) {
    return repository.findById(id);
  }
}
