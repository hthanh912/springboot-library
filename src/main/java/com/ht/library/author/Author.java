package com.ht.library.author;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ht.library.book.Book;
import com.ht.library.genre.Genre;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
@Table(name = "authors")
public class Author {
  @Id
  @Column(name = "author_id")
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "birth_date")
  private LocalDateTime birthDate;

  @Column(name = "death_date")
  private LocalDateTime deathDate;

  @Column(name = "about", columnDefinition="TEXT", length = 2048)
  private String about;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
          name = "author_genre",
          joinColumns = @JoinColumn(name = "author_id"),
          inverseJoinColumns = @JoinColumn(name = "genre_id"))
  private Set<Genre> genres = new HashSet<>();

  @ManyToMany
  @JoinTable(
          name = "author_influence",
          joinColumns = @JoinColumn(name = "author_id"),
          inverseJoinColumns = @JoinColumn(name = "influence_author_id")
  )
  private Set<Author> influences = new HashSet<>();

  @Column(name = "average_rating")
  private Float averageRating = 0F;

  @Column(name = "reviews_count")
  private Integer reviewsCount = 0;

  @Column(name = "ratings_count")
  private Integer ratingsCount = 0;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
          name = "author_book",
          joinColumns = @JoinColumn(name = "author_id"),
          inverseJoinColumns = @JoinColumn(name = "book_id"))
  private Set<Book> books = new HashSet<>();

  @CreationTimestamp
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  @Column(name = "created_at", updatable = false)
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  private LocalDateTime updatedAt;

  public void addGenre(Genre genre) {
    genres.add(genre);
  }
}
