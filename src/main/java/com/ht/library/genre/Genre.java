package com.ht.library.genre;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ht.library.book.Book;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "genres")
@Setter
@Getter
public class Genre {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "genre_id")
  private UUID id;

  private String name;

  @Column(name = "description", columnDefinition = "TEXT", length = 2048)
  private String description;

  @JsonIgnore
  @ManyToMany(
      mappedBy = "genres",
      fetch = FetchType.LAZY)
  Set<Book> books;
}
