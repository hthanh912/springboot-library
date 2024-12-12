package com.ht.library.award.dto;

import com.ht.library.award.Designation;

import java.time.LocalDateTime;

public interface BookDetailAward {
    Integer getId();
    String getName();
    Designation getDesignation();
    LocalDateTime getAwardedAt();
    String getCategory();
}
