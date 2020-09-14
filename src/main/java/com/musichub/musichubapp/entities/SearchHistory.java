package com.musichub.musichubapp.entities;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@Entity
@Table(name = "SEARCH_HISTORY")
public class SearchHistory {

    private int id;
    private String searchedWord;
    private User user;
    private LocalDate whenSearched;

    public SearchHistory() {
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "SEARCHED_WORD")
    public String getSearchedWord() {
        return searchedWord;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser() {
        return user;
    }

    @Column(name = "WHEN_SEARCHED")
    public LocalDate getWhenSearched() {
        return whenSearched;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setSearchedWord(String searchedWord) {

        this.searchedWord = searchedWord;
    }

    private void setWhenSearched(LocalDate whenSearched) {
        this.whenSearched = whenSearched;
    }
}
