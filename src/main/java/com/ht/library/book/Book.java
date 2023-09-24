package com.ht.library.book;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ht.library.author.Author;
import com.ht.library.review.Review;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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

  private Integer numberOfReviews = 0;

  private Integer sumOfRate = 0;

  @CreationTimestamp
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  private Date createdAt;

  @UpdateTimestamp
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  private Date updatedAt;

}
