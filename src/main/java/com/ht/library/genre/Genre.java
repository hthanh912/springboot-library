package com.ht.library.genre;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ht.library.author.Author;
import com.ht.library.book.Book;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

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
  @Column(name = "genre_id")
  private String id;

  private String name;

  @JsonIgnore
  @ManyToMany(
          mappedBy = "genres",
          fetch = FetchType.LAZY)
  List<Author> authors;

  @JsonIgnore
  @ManyToMany(
      mappedBy = "genres",
      fetch = FetchType.LAZY)
  Set<Book> books;
}
