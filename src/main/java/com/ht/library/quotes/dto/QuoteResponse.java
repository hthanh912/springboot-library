package com.ht.library.quotes.dto;

import com.ht.library.author.dto.AuthorResponse;
import lombok.*;

import java.util.UUID;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuoteResponse {
    private String content;
    private String bookTitle;
    private UUID bookId;
    private AuthorResponse author;
}
