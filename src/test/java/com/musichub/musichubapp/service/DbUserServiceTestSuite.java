package com.musichub.musichubapp.service;


import com.musichub.musichubapp.entities.Artist;
import com.musichub.musichubapp.entities.SearchHistory;
import com.musichub.musichubapp.entities.User;
import com.musichub.musichubapp.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DbUserServiceTestSuite {

    @Test
    public void testGetAllUsers() {

        //Given

        List<User> usersList = new ArrayList<>();
        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();

        User user1 = new User(1, "Anna", "Budzyń", "anna.budzyn@o2.pl", "haslo123", 32, "K", "Warszawa", "Polska", artistList, searchHistoryList);
        usersList.add(user1);

        UserRepository userRepositoryMock = mock(UserRepository.class);
        when(userRepositoryMock.findAll()).thenReturn(usersList);

        DbUserService dbUserService = new DbUserService(userRepositoryMock);

        //When

        List<User> result = dbUserService.getAllUsers();

        //Then

        Assert.assertEquals(1, result.size());
    }

    @Test
    public void testGetUser() {

        //Given

        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();

        User user1 = new User(1, "Anna", "Budzyń", "anna.budzyn@o2.pl", "haslo123", 32, "K", "Warszawa", "Polska", artistList, searchHistoryList);

        UserRepository userRepositoryMock = mock(UserRepository.class);
        when(userRepositoryMock.findById(1)).thenReturn(Optional.of(user1));

        DbUserService dbUserService = new DbUserService(userRepositoryMock);

        //When

        Optional<User> user = dbUserService.getUser(1);

        //Then

        Assert.assertEquals(true, user.isPresent());

    }

    @Test
    public void testSaveUser() {

        //Given

        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();

        User user1 = new User(1, "Anna", "Budzyń", "anna.budzyn@o2.pl", "haslo123", 32, "K", "Warszawa", "Polska", artistList, searchHistoryList);

        UserRepository userRepositoryMock = mock(UserRepository.class);
        when(userRepositoryMock.save(user1)).thenReturn(user1);

        DbUserService dbUserService = new DbUserService(userRepositoryMock);

        //When

        User user = dbUserService.saveUser(user1);

        //Then

        Assert.assertEquals(user1, user);
    }

    @Test
    public void testDeleteUser() {

        //Given

        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();

        User user1 = new User(1, "Anna", "Budzyń", "anna.budzyn@o2.pl", "haslo123", 32, "K", "Warszawa", "Polska", artistList, searchHistoryList);

        UserRepository userRepositoryMock = mock(UserRepository.class);

        DbUserService dbUserService = new DbUserService(userRepositoryMock);

        //When

        dbUserService.deleteUser(1);

        //Then

        Mockito.verify(userRepositoryMock).deleteById(1);
    }

    @Test
    public void testUpdatePassword() {

        //Given

        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();

        User user1 = new User(1, "Anna", "Budzyń", "anna.budzyn@o2.pl", "haslo123", 32, "K", "Warszawa", "Polska", artistList, searchHistoryList);
        Optional<User> myOptUser = Optional.ofNullable(user1);

        String oldPassword = user1.getPassword();
        int userId = user1.getId();
        String newPassword = "testowe";


        UserRepository userRepositoryMock = mock(UserRepository.class);
        when(userRepositoryMock.findById(userId)).thenReturn(myOptUser);

        DbUserService dbUserService = new DbUserService(userRepositoryMock);

        //When

        dbUserService.updatePassword(oldPassword, newPassword, userId);

        //Then

        Mockito.verify(userRepositoryMock).save(user1);
    }

    @Test
    public void testUpdateFirstName() {

        //Given

        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();

        User user1 = new User(1, "Anna", "Budzyń", "anna.budzyn@o2.pl", "haslo123", 32, "K", "Warszawa", "Polska", artistList, searchHistoryList);
        Optional<User> myOptUser = Optional.ofNullable(user1);

        String password = user1.getPassword();
        String firstName = "Kasia";
        int userId = user1.getId();

        UserRepository userRepositoryMock = mock(UserRepository.class);
        when(userRepositoryMock.findById(userId)).thenReturn(myOptUser);

        DbUserService dbUserService = new DbUserService(userRepositoryMock);

        //When

        dbUserService.updateFirstName(password, userId, firstName);

        //Then

        Mockito.verify(userRepositoryMock).save(user1);
    }

    @Test
    public void testUpdateLastName() {

        //Given

        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();

        User user1 = new User(1, "Anna", "Budzyń", "anna.budzyn@o2.pl", "haslo123", 32, "K", "Warszawa", "Polska", artistList, searchHistoryList);
        Optional<User> myOptUser = Optional.ofNullable(user1);

        String password = user1.getPassword();
        int userId = user1.getId();
        String lastName = "Nowak";

        UserRepository userRepositoryMock = mock(UserRepository.class);
        when(userRepositoryMock.findById(userId)).thenReturn(myOptUser);

        DbUserService dbUserService = new DbUserService(userRepositoryMock);

        //When

        dbUserService.updateLastName(password, userId, lastName);

        //Then

        Mockito.verify(userRepositoryMock).save(user1);

    }

    @Test
    public void testUpdateCity() {

        //Given

        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();

        User user1 = new User(1, "Anna", "Budzyń", "anna.budzyn@o2.pl", "haslo123", 32, "K", "Warszawa", "Polska", artistList, searchHistoryList);
        Optional<User> myOptUser = Optional.ofNullable(user1);

        String password = user1.getPassword();
        int userId = user1.getId();
        String city = "Kraków";

        UserRepository userRepositoryMock = mock(UserRepository.class);
        when(userRepositoryMock.findById(userId)).thenReturn(myOptUser);

        DbUserService dbUserService = new DbUserService(userRepositoryMock);

        //When

        dbUserService.updateCity(password, userId, city);

        //Then

        Mockito.verify(userRepositoryMock).save(user1);
    }

    @Test
    public void testUpdateCountry() {

        //Given

        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();

        User user1 = new User(1, "Anna", "Budzyń", "anna.budzyn@o2.pl", "haslo123", 32, "K", "Warszawa", "Polska", artistList, searchHistoryList);
        Optional<User> myOptUser = Optional.ofNullable(user1);

        String password = user1.getPassword();
        int userId = user1.getId();
        String country = "Germany";


        UserRepository userRepositoryMock = mock(UserRepository.class);
        when(userRepositoryMock.findById(userId)).thenReturn(myOptUser);

        DbUserService dbUserService = new DbUserService(userRepositoryMock);

        //When

        dbUserService.updateCountry(password, userId, country);

        //Then

        Mockito.verify(userRepositoryMock).save(user1);
    }

    @Test
    public void testUpdateAge() {

        //Given

        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();

        User user1 = new User(1, "Anna", "Budzyń", "anna.budzyn@o2.pl", "haslo123", 32, "K", "Warszawa", "Polska", artistList, searchHistoryList);
        Optional<User> myOptUser = Optional.ofNullable(user1);

        String password = user1.getPassword();
        int userId = user1.getId();
        int age = 35;


        UserRepository userRepositoryMock = mock(UserRepository.class);
        when(userRepositoryMock.findById(userId)).thenReturn(myOptUser);
        DbUserService dbUserService = new DbUserService(userRepositoryMock);

        //When

        dbUserService.updateAge(password, userId, age);

        //Then

        Mockito.verify(userRepositoryMock).save(user1);

    }

    @Test
    public void testUpdateEmail() {

        //Given

        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();

        User user1 = new User(1, "Anna", "Budzyń", "anna.budzyn@o2.pl", "haslo123", 32, "K", "Warszawa", "Polska", artistList, searchHistoryList);
        Optional<User> myOptUser = Optional.ofNullable(user1);

        String password = user1.getPassword();
        int userId = user1.getId();
        String email = "anna.budzyn@gmail.com";


        UserRepository userRepositoryMock = mock(UserRepository.class);
        when(userRepositoryMock.findById(userId)).thenReturn(myOptUser);

        DbUserService dbUserService = new DbUserService(userRepositoryMock);

        //When

        dbUserService.updateEmail(password, userId, email);

        //Then

        Mockito.verify(userRepositoryMock).save(user1);
    }
}
