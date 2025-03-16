package com.ht.library.genre.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class GenreItemResponseImpl implements GenreItemResponse, Serializable {

    private String id;
    private String name;

    @JsonCreator
    public GenreItemResponseImpl(@JsonProperty("id") String id, @JsonProperty("name")String name){
        this.id = id;
        this.name = name;
    }
}
