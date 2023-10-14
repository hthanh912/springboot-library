package com.ht.library.book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
            "b.book_id, b.title, b.description, b.cover_url, b.number_of_reviews, b.number_of_ratings, b.average_rate, b.author_author_id, " +
            "au.author_id, au.name, b.created_at, b.updated_at, array_agg(b_g.genre_id) as genres " +
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

    @Modifying
    @Query(value =
        "UPDATE books b " +
        "SET number_of_ratings = (SELECT COUNT(book_book_id) " +
                                    "FROM reviews r " +
                                    "WHERE r.book_book_id = :bookId), " +
            "average_rate = (SELECT AVG(rate) " +
                            "FROM reviews r " +
                            "WHERE r.book_book_id = :bookId), " +
            "number_of_reviews = (SELECT COUNT(book_book_id) " +
                                    "FROM reviews r " +
                                    "WHERE r.book_book_id = :bookId and r.content is not null) " +
        "WHERE b.book_id = :bookId",
    nativeQuery = true)
    void updateBookStatistic(@Param("bookId") UUID bookId);
}
