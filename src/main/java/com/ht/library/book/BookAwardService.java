package com.ht.library.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookAwardService {

    private final BookAwardRepository repository;

    public void insertBookAward(BookAward bookAward) {
        repository.save(bookAward);
    }
}
