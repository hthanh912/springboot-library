package com.ht.library.quotes;

import com.ht.library.quotes.dto.QuoteView;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface QuoteRepository extends JpaRepository<Quote, UUID> {

    @Query(value =
        "SELECT " +
            "q.quote_id AS id, " +
            "q.content AS content, " +
            "q.created_at AS createdAt, " +
            "q.updated_at AS updatedAt, " +
            "b.book_id AS bookId, " +
            "b.title AS bookTitle, " +
            "jsonb_build_object('id', a.author_id, 'name', a.name) AS author " +
        "FROM quotes q " +
        "LEFT JOIN books b ON b.book_id = q.book_book_id " +
        "LEFT JOIN authors a ON a.author_id = b.author_author_id",
        countQuery = "SELECT count(q.quote_id) FROM quotes q",
        nativeQuery = true)
    List<QuoteView> findAllQuotes(Pageable pageable);
    List<Quote> findAllByBookId(@Param("book_id") UUID bookId);
}
