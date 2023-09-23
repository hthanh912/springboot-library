package com.ht.library.review.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequestDTO {
  private String content;
  private Integer rate;
}
