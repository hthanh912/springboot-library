package com.ht.library.award.dto;

import com.ht.library.award.Designation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookDetailAwardImpl implements BookDetailAward, Serializable {
    private Integer id;
    private String name;
    private Designation designation;
    private LocalDateTime awardedAt;
    private String category;
}
