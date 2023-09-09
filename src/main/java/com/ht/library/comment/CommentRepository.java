package com.ht.library.comment;

import com.ht.library.user.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
interface CommentRepository extends JpaRepository<Comment, UUID> {
//  @Query("SELECT * FROM comments WHERE book_book_id = :book_id")
  List<Comment> findAllByBookId(@Param("book_id") UUID id, Pageable pageable);
}
