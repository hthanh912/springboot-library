package com.ht.library.author;

import com.ht.library.author.dto.AuthorDetailView;
import com.ht.library.author.dto.AuthorResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

  @Query(value =
      "SELECT " +
            "a.author_id AS id, " +
            "a.name AS name, " +
            "a.birth_date AS birthDate, " +
            "a.death_date AS deathDate, " +
            "a.about AS about, " +
            "a.average_rating AS averageRating, " +
            "a.reviews_count AS reviewsCount, " +
            "a.ratings_count AS ratingsCount, " +
            "a.created_at AS createdAt, " +
            "a.updated_at AS updatedAt, " +
            "CASE " +
                "WHEN COUNT(i.author_id) = 0 THEN '[]' " +
                "ELSE json_agg(DISTINCT jsonb_build_object('id', i.author_id, 'name', i.name)) " +
            "END AS influences, " +
            "CASE " +
                "WHEN COUNT(g.name) = 0 THEN '[]' " +
                "ELSE json_agg(distinct jsonb_build_object('id', a_g.genre_id, 'name', g.name)) " +
            "END AS genres " +
            "FROM authors a " +
            "LEFT JOIN author_influence a_i " +
                "ON a.author_id = a_i.author_id " +
            "LEFT JOIN authors i " +
                "ON i.author_id = a_i.influence_author_id " +
            "LEFT JOIN author_genre a_g " +
                "ON a.author_id = a_g.author_id " +
            "LEFT JOIN genres g " +
                "ON g.genre_id = a_g.genre_id " +
            "WHERE a.author_id = :id " +
            "GROUP BY a.author_id",
      nativeQuery = true)
  AuthorDetailView findAuthorDetailById(@Param("id") Integer id);

  @Query(value =
        "SELECT " +
            "a.author_id AS id, " +
            "a.name AS name, " +
            "a.average_rating AS averageRating, " +
            "CASE " +
                "WHEN COUNT(g.name) = 0 THEN '[]' " +
                "ELSE json_agg(distinct jsonb_build_object('id', a_g.genre_id, 'name', g.name)) " +
                "END AS genres " +
        "FROM authors a " +
        "LEFT JOIN author_genre a_g " +
            "ON a.author_id = a_g.author_id " +
        "LEFT JOIN genres g " +
            "ON g.genre_id = a_g.genre_id " +
        "GROUP BY a.author_id",
      nativeQuery = true)
  List<AuthorResponse> findAuthorWithGenres(Pageable pageable);

}
