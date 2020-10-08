package com.musichub.musichubapp.controller;

import com.musichub.musichubapp.domain.Dto.UserDto;
import com.musichub.musichubapp.entities.Artist;
import com.musichub.musichubapp.entities.SearchHistory;
import com.musichub.musichubapp.entities.User;
import com.musichub.musichubapp.facade.UserFacade;
import com.musichub.musichubapp.mapper.SearchHistoryMapper;
import com.musichub.musichubapp.mapper.UserMapper;
import com.musichub.musichubapp.repository.ArtistGradeRepository;
import com.musichub.musichubapp.repository.ArtistRepository;
import com.musichub.musichubapp.repository.SearchHistoryRepository;
import com.musichub.musichubapp.service.DbArtistService;
import com.musichub.musichubapp.service.DbUserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserControllerTestSuite {

    @Before
    public void setUp() {
        initMocks(this);
    }

// Controller as POJO object (not MockMVC) to not set up Spring context due to time of execution.

    @InjectMocks
    private UserController userController;

    @Mock
    private DbUserService dbUserServiceMock;

    @Mock
    private UserMapper userMapperMock;

    @Mock
    private UserFacade userFacadeMock;

    @Mock
    private SearchHistoryMapper searchHistoryMapperMock;

    @Test
    public void testGetUser() throws Exception {

        // Given

        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();
        UserDto userDto = new UserDto(0, "Kasia", "Nowak", "kasia.nowak@o2.pl", "haslo123", 30, "K", "Kraków", "Polska", artistList, searchHistoryList);

        List<User> usersList = new ArrayList<>();
        User user1 = new User(0, "Anna", "Budzyń", "anna.budzyn@gmail.com", "kwiatek1!", 35, "K", "Łódź", "Polska", artistList, searchHistoryList);
        User user2 = new User(1, "Ola", "Baran", "ola.baran@o2.pl", "ares34", 25, "K", "Warszawa", "Polska", artistList, searchHistoryList);
        usersList.add(user1);
        usersList.add(user2);

        when(userMapperMock.mapToUserDto(user1)).thenReturn(userDto);


        when(dbUserServiceMock.getUser(0)).thenReturn(java.util.Optional.of(user1));

        // When

        UserDto result = userController.getUser(0);

        // Then
        Assert.assertEquals("Kasia", result.getFirstName());
        Mockito.verify(userMapperMock).mapToUserDto(user1);
    }

    @Test
    public void testGetUsers() {

        // Given

        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();
        List<UserDto> userDtoList = new ArrayList<>();
        UserDto userDto = new UserDto(0, "Kasia", "Nowak", "kasia.nowak@o2.pl", "haslo123", 30, "K", "Kraków", "Polska", artistList, searchHistoryList);
        UserDto userDto1 = new UserDto(1, "Ola", "Baran", "ola.baran@o2.pl", "ares34", 25, "K", "Warszawa", "Polska", artistList, searchHistoryList);

        userDtoList.add(userDto);
        userDtoList.add(userDto1);


        List<User> usersList = new ArrayList<>();
        User user1 = new User(0, "Anna", "Budzyń", "anna.budzyn@gmail.com", "kwiatek1!", 35, "K", "Łódź", "Polska", artistList, searchHistoryList);
        User user2 = new User(1, "Weronika", "Wąs", "weronika.was.@gmail.com", "antr45!", 40, "K", "Gdańsk", "Polska", artistList, searchHistoryList);
        usersList.add(user1);
        usersList.add(user2);

        when(userFacadeMock.getUsers()).thenReturn(userDtoList);

        // When

        List<UserDto> result = userController.getUsers();

        // Then
        Assert.assertEquals(userDtoList.size(), result.size());
        Assert.assertEquals(2, result.size());
        Assert.assertEquals(2, userDtoList.size());
        Assert.assertEquals(usersList.size(), userDtoList.size());
        Assert.assertEquals(usersList.get(0).getId(), userDtoList.get(0).getId());
    }

    @Test
    public void testDeleteUser() {

        // Given

        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();

        List<User> usersList = new ArrayList<>();
        User user1 = new User(0, "Anna", "Budzyń", "anna.budzyn@gmail.com", "kwiatek1!", 35, "K", "Łódź", "Polska", artistList, searchHistoryList);
        User user2 = new User(1, "Weronika", "Wąs", "weronika.was.@gmail.com", "antr45!", 40, "K", "Gdańsk", "Polska", artistList, searchHistoryList);
        usersList.add(user1);
        usersList.add(user2);

        SearchHistoryRepository searchHistoryRepositoryMock = mock(SearchHistoryRepository.class);

        ArtistRepository artistRepositoryMock = mock(ArtistRepository.class);

        ArtistGradeRepository artistGradeRepositoryMock = mock(ArtistGradeRepository.class);


        DbArtistService dbArtistService = new DbArtistService(artistRepositoryMock, artistGradeRepositoryMock, searchHistoryRepositoryMock);

        // When

        userController.deleteUser(0);

        // Then

        verify(dbUserServiceMock).deleteUser(0);

    }

    @Test
    public void testUpdateUser() {

        // Given

        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();

        UserDto userDto = new UserDto(0, "Kasia", "Nowak", "kasia.nowak@o2.pl", "haslo123", 30, "K", "Kraków", "Polska", artistList, searchHistoryList);
        UserDto userDto1 = new UserDto(1, "Ola", "Baran", "ola.baran@o2.pl", "ares34", 25, "K", "Warszawa", "Polska", artistList, searchHistoryList);


        User user1 = new User(0, "Anna", "Budzyń", "anna.budzyn@gmail.com", "kwiatek1!", 35, "K", "Łódź", "Polska", artistList, searchHistoryList);
        User user2 = new User(1, "Weronika", "Wąs", "weronika.was.@gmail.com", "antr45!", 40, "K", "Gdańsk", "Polska", artistList, searchHistoryList);

        when(userMapperMock.mapToUserDto(user1)).thenReturn(userDto1);
        when(dbUserServiceMock.saveUser(user1)).thenReturn(user1);
        when(userMapperMock.mapToUser(userDto)).thenReturn(user1);

        // When

        UserDto result = userController.updateUser(userDto);

        // Then

        Assert.assertEquals(userDto1, result);

    }

    @Test
    public void testCreateUser() {

        // Given

        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();

        UserDto userDto = new UserDto(0, "Kasia", "Nowak", "kasia.nowak@o2.pl", "haslo123", 30, "K", "Kraków", "Polska", artistList, searchHistoryList);
        User user1 = new User(0, "Anna", "Budzyń", "anna.budzyn@gmail.com", "kwiatek1!", 35, "K", "Łódź", "Polska", artistList, searchHistoryList);
        User user2 = new User(1, "Weronika", "Wąs", "weronika.was.@gmail.com", "antr45!", 40, "K", "Gdańsk", "Polska", artistList, searchHistoryList);

        when(dbUserServiceMock.saveUser(user1)).thenReturn(user1);
        when(userMapperMock.mapToUser(userDto)).thenReturn(user2);

        // When

        userController.createUser(userDto);

        // Then

        verify(dbUserServiceMock).saveUser(user2);
    }

    @Test
    public void testUpdatePassword() {

        // Given

        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();

        User user1 = new User(0, "Anna", "Budzyń", "anna.budzyn@gmail.com", "kwiatek1!", 35, "K", "Łódź", "Polska", artistList, searchHistoryList);

        String oldPassword = user1.getPassword();
        int userId = user1.getId();
        String newPassword = "hdbye19!";

        // When

        userController.updatePassword(oldPassword, newPassword, userId);

        // Then

        verify(dbUserServiceMock).updatePassword(oldPassword, newPassword, userId);
    }

    @Test
    public void testUpdateName() {

        // Given

        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();

        User user1 = new User(0, "Weronika", "Wąs", "weronika.was.@gmail.com", "antr45!", 40, "K", "Gdańsk", "Polska", artistList, searchHistoryList);

        String password = user1.getPassword();
        int userId = user1.getId();

        // When

        userController.updateName(password, userId, user1.getFirstName());

        // Then

        verify(dbUserServiceMock).updateFirstName(password, userId, user1.getFirstName());
    }

    @Test
    public void testUpdateLastName() {

        // Given

        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();

        User user1 = new User(0, "Weronika", "Wąs", "weronika.was.@gmail.com", "antr45!", 40, "K", "Gdańsk", "Polska", artistList, searchHistoryList);

        String password = user1.getPassword();
        int userId = user1.getId();

        // When

        userController.updateLastName(password, userId, user1.getLastName());

        // Then

        verify(dbUserServiceMock).updateLastName(password, userId, user1.getLastName());
    }

    @Test
    public void testUpdateCity() {

        // Given

        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();

        User user1 = new User(0, "Kasia", "Nowak", "kasia.nowak@o2.pl", "haslo123", 30, "K", "Kraków", "Polska", artistList, searchHistoryList);

        String password = user1.getPassword();
        int userId = user1.getId();

        // When

        userController.updateCity(password, userId, user1.getCity());

        // Then

        verify(dbUserServiceMock).updateCity(password, userId, user1.getCity());
    }
}
