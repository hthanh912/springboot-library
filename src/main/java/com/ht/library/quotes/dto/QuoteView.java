package com.ht.library.quotes.dto;

import com.ht.library.author.dto.AuthorView;

import java.util.UUID;

public interface QuoteView {
    String getContent();
    String getBookTitle();
    UUID getBookId();
    AuthorView getAuthor();
}
