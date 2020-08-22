package com.musichub.musichubapp.entities;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Entity
@Table(name = "ARTISTS")
public class Artist {

    private int id;
    private String name;
    private String genre;
    private List<User> likes = new ArrayList<>();

    public Artist() {
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "GENRES")
    public String getGenre() {
        return genre;
    }

    @ManyToMany(mappedBy = "likedArtists")
    public List<User> getLikes(){
        return likes;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setLikes(List<User> likes) { this.likes = likes;}

    private void setGenre(String genre) {
        this.genre = genre;
    }


}
