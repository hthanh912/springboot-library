package com.ht.library.review;

import com.ht.library.review.dto.ReviewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class ReviewController {

  private final ReviewService service;

  @GetMapping("/books/{id}/reviews")
  public ResponseEntity<List<ReviewResponse>> getReviewByBookId(@PathVariable UUID id, Pageable pageable) {
    return ResponseEntity.ok(service.getReviewByBookId(id, pageable));
  }

//  @PostMapping("/books/{bookId}/comments")
//  public ResponseEntity<Object> insertComment(@PathVariable UUID bookId, @RequestBody CommentRequestDTO dto) {
//    Comment insertedComment = service.insertComment(bookId, dto);
//    if (insertedComment != null) {
//      return ResponseHandler.generateResponse("Inserted comment", HttpStatus.OK, null);
//    } else return ResponseHandler.generateResponse("Failed to insert comment", HttpStatus.BAD_REQUEST, null);
//  }

}
