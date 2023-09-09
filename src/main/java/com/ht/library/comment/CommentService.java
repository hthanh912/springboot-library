package com.ht.library.comment;

import com.ht.library.comment.dto.CommentResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface CommentService {
  List<CommentResponseDTO> getCommentByBookId(UUID bookId, Pageable pageable);
//  Comment insertComment(UUID bookId, CommentRequestDTO dto);
}
