package com.ht.library.comment;

import com.ht.library.book.BookRepository;
import com.ht.library.book.BookService;

import com.ht.library.comment.dto.CommentResponseDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

  private final CommentRepository repository;
  private final ModelMapper mapper;
  private final BookService bookService;
  private final BookRepository bookRepository;

  @Override
  public List<CommentResponseDTO> getCommentByBookId(UUID bookId, Pageable pageable) {
    return repository.findAllByBookId(bookId, pageable)
        .stream()
        .map(e ->  mapper.map(e, CommentResponseDTO.class))
        .collect(Collectors.toList());
  }

//  @Override
//  public Comment insertComment(UUID bookId, CommentRequestDTO dto) {
//    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//    Book book = bookService.getBookById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
//    book.setNumberOfReviews(book.getNumberOfReviews() + 1);
//    book.setSumOfRate(book.getSumOfRate() + dto.getRate());
//    bookRepository.save(book);
//    Comment comment = Comment.builder()
//        .book(book)
//        .user((User) authentication.getPrincipal())
//        .content(dto.getContent())
//        .rate(dto.getRate())
//        .build();
//    return repository.save(comment);
//  }
}
