package com.ht.library.genre.dto;

import lombok.*;

import java.util.UUID;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenreItemResponse {
  private UUID id;
  private String name;
}
