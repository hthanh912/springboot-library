package com.ht.library.author;

import com.ht.library.author.dto.AuthorResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AuthorService {
  List<AuthorResponse> getAllAuthor();
  Optional<Author> getAuthorById(UUID id);
}
