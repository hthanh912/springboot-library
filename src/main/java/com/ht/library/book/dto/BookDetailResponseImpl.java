package com.ht.library.book.dto;

import com.ht.library.author.dto.AuthorResponse;
import com.ht.library.award.dto.BookDetailAward;
import com.ht.library.configs.cloudinary.CloudinaryConfig;
import com.ht.library.genre.dto.GenreItemResponse;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookDetailResponseImpl implements BookDetailResponse, Serializable {

    private Integer id;
    private String title;
    private String titleComplete;
    private String description;
    private Set<GenreItemResponse> genres;
    private String asin;
    private String isbn;
    private String isbn13;
    private String publisher;
    private Set<String> series;
    private Set<AuthorResponse> authors;
    private LocalDateTime publishDate;
    private Set<String> characters;
    private Set<String> places;
    private Integer[] ratingHistogram;
    private Float averageRating;
    private Integer ratingsCount;
    private Integer reviewsCount;
    private Integer numPages;
    private String language;
    private Set<BookDetailAward> awards;

    @Override
    public String getImageUrl() {
        return CloudinaryConfig.getImageUrl(
                getId().toString(), CloudinaryConfig.FOLDER.books.toString(), CloudinaryConfig.LARGE_WIDTH);
    }
}
