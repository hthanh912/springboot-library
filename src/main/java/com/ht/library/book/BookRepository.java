package com.ht.library.book;
import com.ht.library.book.dto.BookResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

//    @Query(value = "SELECT * FROM BOOKS b where '41053c4e-e7f2-462f-9dd6-8755704691f6' in b.genres" , nativeQuery = true)
    @Query(value =
        "SELECT b.book_id, b.author_author_id, b.title, b.number_of_reviews, b.sum_of_rate, b.created_at, b.updated_at " +
        "FROM books b " +
            "LEFT JOIN book_genre b_g on b.book_id = b_g.book_id " +
            "LEFT JOIN authors on b.author_author_id = authors.author_id  " +
        "WHERE b_g.genre_id = :genreId" ,
        nativeQuery = true)
    List<Book> findAllByGenreIds(UUID genreId);
}
