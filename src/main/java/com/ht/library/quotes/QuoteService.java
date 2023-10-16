package com.ht.library.quotes;

import com.ht.library.quotes.dto.QuoteView;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface QuoteService {
    List<QuoteView> getAllQuotes(Pageable pageable);
    List<Quote> getQuoteByBookId(UUID bookId);
    void delete(UUID id);
}
