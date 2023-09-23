package com.ht.library.review;

import com.ht.library.review.dto.ReviewResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ReviewService {
  List<ReviewResponseDTO> getReviewByBookId(UUID bookId, Pageable pageable);
//  Comment insertComment(UUID bookId, CommentRequestDTO dto);
}
