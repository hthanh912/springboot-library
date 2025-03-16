package com.ht.library.author.dto;

import com.ht.library.configs.cloudinary.CloudinaryConfig;
import com.ht.library.genre.dto.GenreItemResponse;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AuthorDetailResponseImpl implements AuthorDetailResponse, Serializable {

    private Integer id;
    private String name;
    private LocalDateTime birthDate;
    private LocalDateTime deathDate;
    private String about;
    private List<InfluenceAuthor> influences;
    private Float averageRating;
    private Set<GenreItemResponse> genres;
    private Integer reviewsCount;
    private Integer ratingsCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @Override
    public String getImageUrl() {
        return CloudinaryConfig.getImageUrl(
                getId().toString(), CloudinaryConfig.FOLDER.authors.toString(), CloudinaryConfig.MEDIUM_WIDTH);
    };

    @AllArgsConstructor
    @Getter
    @Setter
    public static class InfluenceAuthorImpl implements InfluenceAuthor, Serializable {
        private Integer id;
        private String name;
    }
}
