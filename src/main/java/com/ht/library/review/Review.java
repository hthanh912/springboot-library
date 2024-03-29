package com.ht.library.review;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ht.library.book.Book;
import com.ht.library.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "reviews")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "review_id")
  private UUID id;

  private String content;

  private Integer rate;

  @ManyToOne(fetch = FetchType.LAZY)
  private User user;

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
