package com.musichub.musichubapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class ArtistDto {

    private int id;
    private String name;
    private String genre;
    private List<User> likes;
}
