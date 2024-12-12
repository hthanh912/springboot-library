package com.ht.library.review;

import com.ht.library.book.BookRepository;
import com.ht.library.exception.ResourceNotFoundException;
import com.ht.library.review.dto.ReviewRequest;
import com.ht.library.review.dto.ReviewResponse;
import com.ht.library.user.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

  private final ReviewRepository repository;
  private final ModelMapper mapper;
  private final BookRepository bookRepository;

  @Override
  public List<ReviewResponse> getReviewByBookId(Integer bookId, Pageable pageable) {
//    return repository.findByBookId(bookId, pageable)
//        .stream()
//        .map(e ->  mapper.map(e, ReviewResponse.class))
//        .collect(Collectors.toList());
    return null;
  }

  @Override
  @Transactional
  public ReviewResponse insertReview(Integer bookId, ReviewRequest requestDto) {
//    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//    if (!bookRepository.existsById(Integer)) throw new ResourceNotFoundException("Book not found");
//    Review review = Review.builder()
//        .content(requestDto.getContent())
//        .rate(requestDto.getRate())
//        .user((User)authentication.getPrincipal())
//        .book(bookRepository.getReferenceById(bookId))
//        .build();
//    Review insertedReview = repository.save(review);
//    bookRepository.updateBookStatistic(bookId);
//    return mapper.map(insertedReview, ReviewResponse.class);
    return null;
  }
}
