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
  List<Review> findByBookId(UUID bookId, Pageable pageable);
}
