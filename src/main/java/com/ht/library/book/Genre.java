package com.ht.library.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

  @JsonIgnore
  @ManyToMany(
      mappedBy = "genres",
      fetch = FetchType.LAZY)
  Set<Book> books;
}
