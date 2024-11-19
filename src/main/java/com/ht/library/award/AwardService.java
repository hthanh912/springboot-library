package com.ht.library.award;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AwardService {

    private final AwardRepository repository;

    public Award insertAward(Award award){
        return repository.save(award);
    }

    public Optional<Award> getAwardById(Integer id) {
        return repository.findById(id);
    }
}
