package com.ht.library.review;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
interface ReviewRepository extends JpaRepository<Review, UUID> {
  @Query(value =
      "SELECT v " +
      "FROM Review v " +
      "JOIN FETCH v.user u " +
      "WHERE v.book.id = :bookId ")
  List<Review> findByBookId(@Param("bookId") UUID bookId, Pageable pageable);
}
