package com.ht.library.comment.dto;

import com.ht.library.user.UserDTO;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponseDTO {
  private UUID id;
  private String content;
  private Integer rate;
  private Date createdAt;
  private Date updatedAt;
  private UserDTO user;
}
