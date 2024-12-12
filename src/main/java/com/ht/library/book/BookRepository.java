package com.ht.library.book;
import com.ht.library.book.dto.BookDetailResponse;
import com.ht.library.book.dto.BookResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "SELECT " +
            "b.book_id AS id, " +
            "b.title AS title, " +
            "b.ratings_count AS ratingsCount, " +
            "b.average_rating AS averageRating, " +
            "CASE " +
            "   WHEN COUNT(au.author_id) = 0 THEN '[]' " +
            "   ELSE json_agg(DISTINCT jsonb_build_object('id', au.author_id, 'name', au.name)) " +
            "   END AS authors, " +
            "CASE " +
            "   WHEN COUNT(g.name) = 0 THEN '[]' " +
            "   ELSE json_agg(distinct jsonb_build_object('id', g.genre_id, 'name', g.name)) " +
            "   END AS genres " +
            "FROM books b " +
            "LEFT JOIN author_book a_b " +
            "    ON b.book_id = a_b.book_id " +
            "LEFT JOIN authors au " +
            "   ON a_b.author_id = au.author_id " +
            "LEFT JOIN book_genre b_g " +
            "   ON b_g.book_id = b.book_id " +
            "LEFT JOIN genres g " +
            "   ON g.genre_id = b_g.genre_id " +
            "WHERE cardinality(:authorIds) = 0 OR au.author_id = ANY(:authorIds) " +
            "GROUP BY b.book_id " +
            "HAVING cardinality(:genreIds) = 0 OR array_agg(b_g.genre_id) && :genreIds",
            countQuery = "SELECT count(b.book_id) FROM books b",
            nativeQuery = true)
    List<BookResponse> findByQuery(@Param("authorIds") Integer[] authorIds, @Param("genreIds") String[] genreIds, Pageable pageable);

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

    @Query(value = "SELECT " +
            "b.book_id AS id, " +
            "b.title AS title, " +
            "b.title_complete AS titleComplete, " +
            "b.description AS description, " +
            "b.ratings_count AS ratingsCount, " +
            "b.average_rating AS averageRating, " +
            "b.asin AS asin, " +
            "b.isbn AS isbn, " +
            "b.isbn13 AS isbn13, " +
            "b.publisher AS publisher, " +
            "b.published_date AS publishDate, " +
            "b.ratings_count AS ratingsCount, " +
            " b.reviews_count AS reviewsCount, " +
            "b.rating_histogram AS ratingHistogram, " +
            "b.num_pages AS numPages, " +
            "b.language AS language, " +
            "CASE " +
            "   WHEN COUNT(b_s.series) = 0 THEN '[]' " +
            "   ELSE json_agg(DISTINCT b_s.series) " +
            "   END AS series, " +
            "CASE " +
            "   WHEN COUNT(b_c.characters) = 0 THEN '[]' " +
            "   ELSE json_agg(DISTINCT b_c.characters) " +
            "   END AS characters, " +
            "CASE " +
            "   WHEN COUNT(b_p.places) = 0 THEN '[]' " +
            "   ELSE json_agg(DISTINCT b_p.places) " +
            "   END AS places, " +
            "CASE  " +
            "   WHEN COUNT(au.author_id) = 0 THEN '[]' " +
            "   ELSE json_agg(DISTINCT jsonb_build_object('id', au.author_id, 'name', au.name)) " +
            "   END AS authors, " +
            "CASE " +
            "   WHEN COUNT(g.genre_id) = 0 THEN '[]' " +
            "   ELSE json_agg(distinct jsonb_build_object('id', g.genre_id, 'name', g.name)) " +
            "   END AS genres, " +
            "CASE " +
            "   WHEN COUNT(aw.award_id) = 0 THEN '[]' " +
            "   ELSE json_agg(distinct jsonb_build_object('id', aw.award_id, 'name', aw.name, 'category', b_a.category, 'designation', b_a.designation, 'awardedAt', b_a.awarded_at))    " +
            "   END AS awards  " +
            "FROM books b    " +
            "LEFT JOIN author_book a_b " +
            "   ON b.book_id = a_b.book_id " +
            "LEFT JOIN authors au    " +
            "   ON a_b.author_id = au.author_id " +
            "LEFT JOIN book_genre b_g " +
            "   ON b_g.book_id = b.book_id " +
            "LEFT JOIN genres g    " +
            "   ON g.genre_id = b_g.genre_id " +
            "LEFT JOIN book_series b_s  " +
            "   ON b_s.book_book_id = b.book_id " +
            "LEFT JOIN book_characters b_c " +
            "   ON  b_c.book_book_id = b.book_id " +
            "LEFT JOIN book_places b_p " +
            "   ON  b_p.book_book_id = b.book_id " +
            "LEFT JOIN book_award b_a " +
            "   ON b_a.book_id = b.book_id " +
            "LEFT JOIN awards aw " +
            "   ON aw.award_id = b_a.award_id " +
            "WHERE b.book_id = :bookId " +
            "GROUP BY b.book_id",
            nativeQuery = true)
    Optional<BookDetailResponse> getBookDetailById(@Param("bookId") Integer bookId);
}
