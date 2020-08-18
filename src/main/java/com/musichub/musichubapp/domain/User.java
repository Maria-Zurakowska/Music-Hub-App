package com.musichub.musichubapp.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    public User() {
    }

    public User(String firstName, String lastName, String email, String password, int age, String gender, String city, String country){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email=email;
        this.password=password;
        this.age=age;
        this.gender=gender;
        this.city=city;
        this.country=country;
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

    private void setId(int id) {
        this.id = id;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setGender(String gender) {
        this.gender = gender;
    }

    private void setCity(String city) {
        this.city = city;
    }

    private void setCountry(String country) {
        this.country = country;
    }


    @ManyToMany
    @JoinTable(
            name= "USER_FAVOURITE_ARTIST",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn (name = "artist_id") )
    private List<Artist> likedArtists;
}
