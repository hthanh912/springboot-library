package com.ht.library.quotes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ht.library.book.Book;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "quotes")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "quote_id")
    private UUID id;

    private String content;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createdAt;

    @UpdateTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date updatedAt;
}