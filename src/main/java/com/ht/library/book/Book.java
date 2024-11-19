package com.ht.library.book;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ht.library.author.Author;
import com.ht.library.genre.Genre;
import com.ht.library.review.Review;
import com.ht.library.user.UserBook;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
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
  @Column(name = "book_id")
  private Integer id;

  @Column(name = "goodread_url")
  private String goodreadUrl;

  @Column(name = "title")
  private String title;

  @Column(name = "title_complete")
  private String titleComplete;

  @Column(name = "description", length = 8192)
  private String description;

  @Column(name = "image_url")
  private String imageUrl;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
          name = "book_genre",
          joinColumns = @JoinColumn(name = "book_id"),
          inverseJoinColumns = @JoinColumn(name = "genre_id"))
  private List<Genre> genres = new ArrayList<>();

  @Column(name = "asin")
  private String asin;

  @Column(name = "isbn")
  private String isbn;

  @Column(name = "isbn13")
  private String isbn13;

  @Column(name = "publisher")
  private String publisher;

  @ElementCollection
  @Column(name = "series")
  private List<String> series;

  @JsonIgnore
  @ManyToMany(
          mappedBy = "books",
          fetch = FetchType.LAZY)
  List<Author> authors;

  @Column(name = "published_date")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  private LocalDateTime publishDate;

  @ElementCollection
  @Column(name = "characters")
  private List<String> characters;

  @ElementCollection
  @Column(name = "places")
  private List<String> places;

  @Column(name = "rating_histogram")
  private String ratingHistogram;

  @Column(name = "ratings_count")
  private Integer ratingsCount;

  @Column(name = "reviews_count")
  private Integer reviewsCount;

  @Column(name = "num_pages")
  private Integer numPages;

  @Column(name = "language")
  private String language;

  @OneToMany(mappedBy = "book")
  private Set<BookAward> bookAwards;

  @OneToMany(
      mappedBy = "book",
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  private List<Review> reviews = new ArrayList<>();

  @JsonIgnore
  @OneToMany(mappedBy = "book")
  Set<UserBook> userBooks;

  @CreationTimestamp
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  private LocalDateTime updatedAt;

}
