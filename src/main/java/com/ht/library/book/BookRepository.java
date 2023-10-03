package com.ht.library.book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
    List<Book> findAllByAuthorId(UUID authorId);

    @Query(value =
        "SELECT " +
            "b.book_id, b.title, b.number_of_reviews, b.sum_of_rate, b.author_author_id, au.author_id, au.name, b.created_at, b.updated_at, array_agg(b_g.genre_id) as genres " +
        "FROM books b " +
        "LEFT JOIN authors au " +
            "ON au.author_id = b.author_author_id " +
        "LEFT JOIN book_genre b_g " +
            "ON b_g.book_id = b.book_id " +
        "WHERE " + "" +
            ":authorId = '00000000-0000-0000-0000-000000000000' " +
            "OR au.author_id = :authorId " +
        "GROUP BY b.book_id, au.author_id, au.name " +
        "HAVING " +
            ":genreIds IS NULL " +
            "OR array_agg(b_g.genre_id) @> :genreIds",
        countQuery = "SELECT count(b.book_id) FROM books b",
        nativeQuery = true
    )
    List<Book> findBookByQuery(@Param("authorId") UUID authorId,@Param("genreIds") UUID[] genreIds, Pageable pageable);
}
