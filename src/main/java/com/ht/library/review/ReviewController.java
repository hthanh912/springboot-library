package com.ht.library.review;

import com.ht.library.review.dto.ReviewRequest;
import com.ht.library.review.dto.ReviewResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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

  @PostMapping("/books/{bookId}/reviews")
  public ResponseEntity<ReviewResponse> insertReview(@PathVariable UUID bookId, @RequestBody ReviewRequest reviewDto) {
    return ResponseEntity.ok(service.insertReview(bookId, reviewDto));
  }
}
