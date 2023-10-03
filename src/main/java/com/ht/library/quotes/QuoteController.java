package com.ht.library.quotes;

import com.ht.library.quotes.dto.QuoteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("quotes")
@RequiredArgsConstructor
public class QuoteController {

    private final QuoteService service;

    @GetMapping("")
    public ResponseEntity<List<QuoteResponse>> getAllQuotes(@PageableDefault(value = 10, page = 0) Pageable pageable) {
        return ResponseEntity.ok(service.getAllQuotes(pageable));
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<List<Quote>> getAllQuotesByBookId(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getQuoteByBookId(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable UUID id) {
        service.delete(id);
    }
}