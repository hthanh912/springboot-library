package com.ht.library.user;

import com.ht.library.book.Book;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "user_book")
@Getter
@Setter
public class UserBook {
    @GeneratedValue
    @Id
    private UUID id;

    // User likes book
    private boolean isFavorite;

    // User reading status
    private ReadingStatus readingStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    public Book book;
}
