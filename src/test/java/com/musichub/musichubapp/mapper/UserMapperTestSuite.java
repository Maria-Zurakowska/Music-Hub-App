package com.musichub.musichubapp.mapper;

import com.musichub.musichubapp.domain.Dto.UserDto;
import com.musichub.musichubapp.entities.Artist;
import com.musichub.musichubapp.entities.SearchHistory;
import com.musichub.musichubapp.entities.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserMapperTestSuite {

    private UserMapper userMapper = new UserMapper();

    @Test
    public void testMapToUserDtoList() {

        // Given

        List<Artist> artistList = new ArrayList<>();
        List<User> usersList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();
        artistList.add(new Artist(0, "Radiohead", "alternative rock", usersList));
        artistList.add(new Artist(1, "Nirvana", "grunge", usersList));

        User user1 = new User(0, "Kasia", "Nowak", "kasia.nowak@o2.pl", "haslo123", 30, "K", "Kraków", "Polska", artistList, searchHistoryList);
        User user2 = new User(1, "Anna", "Budzyń", "anna.budzyn@gmail.com", "kwiatek1!", 35, "K", "Łódź", "Polska", artistList, searchHistoryList);
        usersList.add(user1);
        usersList.add(user2);

        // When

        List<UserDto> userDtoList = userMapper.mapToUserDtoList(usersList);

        // Then

        Assert.assertEquals(2, userDtoList.size());
        Assert.assertEquals(usersList.size(), userDtoList.size());
        Assert.assertEquals(usersList.get(0).getId(), userDtoList.get(0).getId());
        Assert.assertEquals(usersList.get(0).getCountry(), userDtoList.get(0).getCountry());
        Assert.assertEquals(usersList.get(0).getFirstName(), userDtoList.get(0).getFirstName());
    }

    @Test
    public void testMapToUserDto() {

        // Given

        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();
        User user1 = new User(0, "Kasia", "Nowak", "kasia.nowak@o2.pl", "haslo123", 30, "K", "Kraków", "Polska", artistList, searchHistoryList);

        // When

        UserDto userDto = userMapper.mapToUserDto(user1);

        // Then

        Assert.assertNotNull(userDto);
        Assert.assertEquals("Kraków", userDto.getCity());
        Assert.assertEquals("Kasia", userDto.getFirstName());
    }

    @Test
    public void testMapToUser() {

        // Given

        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();
        List<User> usersList = new ArrayList<>();
        User user2 = new User(1, "Anna", "Budzyń", "anna.budzyn@gmail.com", "kwiatek1!", 35, "K", "Łódź", "Polska", artistList, searchHistoryList);
        usersList.add(user2);

        UserDto userDto = new UserDto(0, "Kasia", "Nowak", "kasia.nowak@o2.pl", "haslo123", 30, "K", "Kraków", "Polska", artistList, searchHistoryList);

        // When

        User result = userMapper.mapToUser(userDto);

        // Then

        Assert.assertEquals("Polska", result.getCountry());
        Assert.assertEquals(userDto.getId(), result.getId());
        Assert.assertEquals("Nowak", result.getLastName());
    }
}
