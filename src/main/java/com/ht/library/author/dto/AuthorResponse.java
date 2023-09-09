package com.ht.library.author.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
@Getter
@Setter
public class AuthorResponse {
  private UUID id;
  private String name;
}
