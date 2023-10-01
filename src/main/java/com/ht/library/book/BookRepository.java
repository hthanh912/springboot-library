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
    List<Book> findAllByAuthorId(UUID authorId);

//    @Query(value =
//        "SELECT b.book_id, b.author_author_id, b.title, b.number_of_reviews, b.sum_of_rate, b.created_at, b.updated_at " +
//        "FROM books b" +
//            "LEFT JOIN book_genre b_g on (array_length((cast(:genreId)), 1) = 0) OR (b.book_id = b_g.book_id) " +
//            "LEFT JOIN authors on b.author_author_id = authors.author_id  " +
//        "WHERE (b_g.genre_id = ANY(:genreId)) " +
//        "OR (array_length((cast(:genreId)), 1) = 0)")
//    List<Book> findAllByGenreIds(UUID[] genreId);

    @Query(value =
        "SELECT b FROM Book b " +
        "LEFT JOIN Author ON b.author_author_id = "
    )
    List<Book> findBookByQuery();
}
