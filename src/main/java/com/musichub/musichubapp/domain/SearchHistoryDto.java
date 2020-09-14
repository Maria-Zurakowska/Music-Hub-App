package com.musichub.musichubapp.domain;

import com.musichub.musichubapp.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
@Getter
@AllArgsConstructor
@ToString
public class SearchHistoryDto {
    private int id;
    private String searchedWord;
    private User user;
    private LocalDate whenSearched;
}
