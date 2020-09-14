package com.musichub.musichubapp.entities;


import lombok.AllArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Entity
@Table(name = "ARTIST_GRADE")
public class ArtistGrade {

    private int id;
    private String artistName;
    private int grade;

    public ArtistGrade() {
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "ARTIST_NAME")
    public String getArtistName() {
        return artistName;
    }

    @Column(name = "GRADE")
    public int getGrade() {
        return grade;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    private void setGrade(int grade) {
        this.grade = grade;
    }
}
