package com.ht.library.author;

import com.ht.library.author.dto.AuthorDetailView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {

  @Query(value =
      "SELECT " +
          "a.author_id AS id, " +
          "a.name AS name," +
          "a.description AS description, " +
          "a.born AS born, " +
          "a.photo_url AS photoUrl, " +
          "a.created_at AS createdAt, " +
          "a.updated_at AS updatedAt, " +
          "sum(b.number_of_ratings) AS numberOfRatings, " +
          "sum(b.number_of_reviews) AS numberOfReviews, " +
          "sum(b.number_of_ratings * b.average_rate)/sum(b.number_of_ratings) AS averageRate, " +
          "json_agg(distinct jsonb_build_object('id', b_g.genre_id, 'name', g.name)) AS genres " +
      "FROM authors a " +
      "LEFT JOIN books b " +
          "ON a.author_id = b.author_author_id " +
      "INNER JOIN book_genre b_g " +
          "ON b_g.book_id = b.book_id " +
      "LEFT JOIN genres g " +
          "ON g.genre_id = b_g.genre_id " +
      "WHERE a.author_id = :id " +
      "GROUP BY a.author_id ",
      nativeQuery = true)
  AuthorDetailView findAuthorDetailById(@Param("id") UUID id);

}
