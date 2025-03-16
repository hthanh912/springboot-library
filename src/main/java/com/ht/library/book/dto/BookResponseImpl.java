package com.ht.library.book.dto;

import com.ht.library.author.dto.AuthorResponse;
import com.ht.library.configs.cloudinary.CloudinaryConfig;
import com.ht.library.genre.dto.GenreItemResponse;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseImpl implements BookResponse, Serializable {
    private Integer id;
    private String title;
    private Set<GenreItemResponse> genres;
    private Integer ratingsCount;
    private Float averageRating;
    private Set<AuthorResponse> authors;

    @Override
    public String getImageUrl() {
        return CloudinaryConfig.getImageUrl(
                getId().toString(), CloudinaryConfig.FOLDER.books.toString(), CloudinaryConfig.SMALL_WIDTH);
    }
}