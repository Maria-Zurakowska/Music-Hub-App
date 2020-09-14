package com.musichub.musichubapp.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "USERS")
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int age;
    private String gender;
    private String city;
    private String country;
    private List<Artist> likedArtists = new ArrayList<>();
    private List<SearchHistory> searchHistoryList;


    public User() {
    }

    public User(int id, String firstName, String lastName, String email, String password, int age, String gender, String city, String country, List<Artist> likedArtists, List<SearchHistory> searchHistoryList){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email=email;
        this.password=password;
        this.age=age;
        this.gender=gender;
        this.city=city;
        this.country=country;
        this.likedArtists = likedArtists;
        this.searchHistoryList = searchHistoryList;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "FIRST_NAME")
    public String getFirstName(){
        return firstName;
    }

    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    @Column(name = "AGE")
    public int getAge() {
        return age;
    }

    @Column(name = "GENDER")
    public String getGender() {
        return gender;
    }

    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    @Column(name = "COUNTRY")
    public String getCountry() {
        return country;
    }


    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(
            name= "USER_FAVOURITE_ARTIST",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn (name = "artist_id", referencedColumnName = "id") )
    public List<Artist> getLikedArtists(){
        return likedArtists;
    }

    @OneToMany(mappedBy = "user")
    public List<SearchHistory> getSearchHistoryList() {
        return searchHistoryList;
    }

    private void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setGender(String gender) {
        this.gender = gender;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private void setCountry(String country) {
        this.country = country;
    }

    private void setLikedArtists(List<Artist> likedArtists){
        this.likedArtists = likedArtists;
    }

    private void setSearchHistoryList(List<SearchHistory> searchHistoryList) {
        this.searchHistoryList = searchHistoryList;
    }
}
