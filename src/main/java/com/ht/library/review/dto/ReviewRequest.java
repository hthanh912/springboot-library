package com.ht.library.review.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {
  private String content;
  private Integer rate;
}
