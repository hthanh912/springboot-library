package com.ht.library.quotes;

import com.ht.library.exception.ResourceNotFoundException;
import com.ht.library.quotes.dto.QuoteView;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService{

    private final QuoteRepository repository;
    private final ModelMapper modelMapper;
    @Override
    public List<QuoteView> getAllQuotes(Pageable pageable) {
        return repository.findAllQuotes(pageable);
    }

    @Override
    public List<Quote> getQuoteByBookId(UUID bookId) {
        return repository.findAllByBookId(bookId).stream().toList();
    }

    @Override
    public void delete(UUID id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else throw new ResourceNotFoundException("Not found quote id " + id);
    }
}
