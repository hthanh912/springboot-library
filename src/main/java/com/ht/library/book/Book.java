package com.ht.library.book;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ht.library.author.Author;
import com.ht.library.genre.Genre;
import com.ht.library.review.Review;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "books")
@Setter
@Getter
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "book_id")
  private UUID id;

  private String title;

  @ManyToOne(fetch = FetchType.EAGER)
  private Author author;

  @OneToMany(
      mappedBy = "book",
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  private List<Review> reviews = new ArrayList<>();

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "book_genre",
      joinColumns = @JoinColumn(name = "book_id"),
      inverseJoinColumns = @JoinColumn(name = "genre_id"))
  private List<Genre> genres = new ArrayList<>();

  private Integer numberOfReviews = 0;

  private Integer sumOfRate = 0;

  @CreationTimestamp
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  private Date createdAt;

  @UpdateTimestamp
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  private Date updatedAt;

}
