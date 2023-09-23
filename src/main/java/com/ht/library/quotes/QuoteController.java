package com.ht.library.quotes;

import com.ht.library.handlers.ResponseHandler;
import com.ht.library.review.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("quotes")
@RequiredArgsConstructor
public class QuoteController {

    private final QuoteService service;

    @GetMapping("")
    public ResponseEntity<Object> getAllQuotes(Pageable pageable) {
        return ResponseHandler.generateResponse("OK", HttpStatus.OK, service.getAllQuotes(pageable));
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Object> getAllQuotesByBookId(@PathVariable UUID id) {
        return ResponseHandler.generateResponse("OK", HttpStatus.OK, service.getQuoteByBookId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable UUID id) {
        service.delete(id);
        return ResponseHandler.generateResponse("Deleted quote id " + id + ".", HttpStatus.OK, null);
    }
}