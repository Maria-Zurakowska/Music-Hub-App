package com.musichub.musichubapp.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@Entity
@Table(name = "ARTISTS")
public class Artist {

    private int id;
    private String name;
    private String genre;

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



    @Column(name = "LIKES")
    public List<User> getLikes() {
        return likes;
    }

    @Column(name = "GENRES")
    public String getGenre() {
        return genre;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }



    private void setLikes(List<User> likes) {
        this.likes = likes;
    }

    private void setGenre(String genre) {
        this.genre = genre;
    }

    @ManyToMany(mappedBy = "likedArtists")
    private List<User> likes;
}
