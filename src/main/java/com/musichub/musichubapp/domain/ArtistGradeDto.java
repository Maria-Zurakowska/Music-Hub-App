package com.musichub.musichubapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class ArtistGradeDto {

    private int id;
    private String artistName;
    private int grade;
}
