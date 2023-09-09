package com.ht.library.comment.dto;

import lombok.*;

import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequestDTO {
  private String content;
  private Integer rate;
}
