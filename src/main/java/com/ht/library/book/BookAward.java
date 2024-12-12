package com.ht.library.book;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ht.library.award.Award;
import com.ht.library.award.Designation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class BookAward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "award_id")
    private Award award;

    @Column(name = "designation", length = 8)
    @Enumerated(EnumType.STRING)
    private Designation designation;

    @Column(name = "awardedAt", length = 8)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime awardedAt;

    @Column(name = "category")
    private String category;

    public BookAward(Book book, Award award, Designation designation, LocalDateTime awardedAt, String category) {
        this.book = book;
        this.award = award;
        this.designation = designation;
        this.awardedAt = awardedAt;
        this.category = category;
    }

}