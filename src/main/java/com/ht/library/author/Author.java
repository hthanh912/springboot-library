package com.ht.library.author;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ht.library.book.Book;
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
@Getter
@Setter
@Table(name = "authors")
public class Author {
  @Id
  @Column(name = "author_id")
  private UUID id;

  @Column(name = "name")
  private String name;

  @Column(name = "description", columnDefinition = "TEXT", length = 2048)
  private String description;

  @Column(name = "photo_url")
  private String photoUrl;

  @OneToMany(fetch = FetchType.LAZY,
      mappedBy = "author",
      cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Book> books = new ArrayList<>();

  @CreationTimestamp
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  private Date createdAt;

  @UpdateTimestamp
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  private Date updatedAt;
}
