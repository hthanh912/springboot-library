package com.ht.library.author.dto;

import com.ht.library.genre.dto.GenreItemResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorResponseImpl implements AuthorResponse, Serializable {
    private Integer id;
    private String name;
    private Float averageRating;
    private List<GenreItemResponse> genres;

    public AuthorResponseImpl(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
