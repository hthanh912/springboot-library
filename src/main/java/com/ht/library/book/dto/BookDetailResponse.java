package com.ht.library.book.dto;

import com.ht.library.author.dto.AuthorView;
import com.ht.library.award.dto.BookDetailAward;
import com.ht.library.configs.cloudinary.CloudinaryConfig;
import com.ht.library.genre.dto.GenreItemResponse;

import java.time.LocalDateTime;
import java.util.Set;

public interface BookDetailResponse {
    Integer getId();
    String getTitle();
    String getTitleComplete();
    String getDescription();
    Set<GenreItemResponse> getGenres();
    String getAsin();
    String getIsbn();
    String getIsbn13();
    String getPublisher();
    Set<String> getSeries();
    Set<AuthorView> getAuthors();
    LocalDateTime getPublishDate();
    Set<String> getCharacters();
    Set<String> getPlaces();
    Integer[] getRatingHistogram();
    Float getAverageRating();
    Integer getRatingsCount();
    Integer getReviewsCount();
    Integer getNumPages();
    String getLanguage();
    default String getImageUrl() {
        return CloudinaryConfig.getImageUrl(
                getId().toString(), CloudinaryConfig.FOLDER.books.toString(), CloudinaryConfig.LARGE_WIDTH);
    }

    Set<BookDetailAward> getAwards();
}