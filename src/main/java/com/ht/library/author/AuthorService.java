package com.ht.library.author;

import com.ht.library.author.dto.AuthorDetailView;
import com.ht.library.author.dto.AuthorPatchRequest;
import com.ht.library.author.dto.AuthorResponse;
import com.ht.library.genre.Genre;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AuthorService {
  List<AuthorResponse> getAllAuthor(Pageable pageable);
  AuthorDetailView getAuthorById(Integer id);
  Optional<Author> getAuthorEntityById(Integer id);
  Author updateAuthor(Integer id, AuthorPatchRequest dto) throws IOException;
  Author insertAuthor(Author author);
  Author addGenreToAuthor(Integer authorId, Genre genre);
}
