package com.ht.library.book;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
//  Book insert(Book book);
//  Page<Book> findAll(Pageable pageable);
//  Book insert(Book book);

//  public List<Book> findSongByArtistId(UUID id, Pageable pageable);
//  public List<Book> findByAlbumId(UUID id);
    List<Book> findAllByAuthorId(UUID authorId);
}
