package com.ht.library.review;

import com.ht.library.review.dto.ReviewRequest;
import com.ht.library.review.dto.ReviewResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ReviewService {
  List<ReviewResponse> getReviewByBookId(Integer bookId, Pageable pageable);
  ReviewResponse insertReview(Integer bookId, ReviewRequest reviewDto);
}
