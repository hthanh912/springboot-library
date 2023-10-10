package com.ht.library.author;

import com.ht.library.author.dto.AuthorDetailResponse;
import com.ht.library.author.dto.AuthorPatchRequest;
import com.ht.library.author.dto.AuthorResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface AuthorService {
  List<AuthorResponse> getAllAuthor();
  AuthorDetailResponse getAuthorById(UUID id);
  Author updateAuthor(UUID id, AuthorPatchRequest dto) throws IOException;
}
