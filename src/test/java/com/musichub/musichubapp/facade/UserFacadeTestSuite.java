package com.musichub.musichubapp.facade;

import com.musichub.musichubapp.domain.Dto.UserDto;
import com.musichub.musichubapp.entities.Artist;
import com.musichub.musichubapp.entities.SearchHistory;
import com.musichub.musichubapp.entities.User;
import com.musichub.musichubapp.mapper.UserMapper;
import com.musichub.musichubapp.service.DbUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserFacadeTestSuite {

    @InjectMocks
    private UserFacade userFacade;

    @Mock
    private UserMapper userMapperMock;

    @Mock
    private DbUserService dbUserServiceMock;

    @Test
    public void testGetUsers(){

        //Given

        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();
        List<User> usersList = new ArrayList<>();
        Artist artist1 = new Artist(1, "Madonna", "pop", usersList);
        artistList.add(artist1);

        SearchHistory searchHistory1 = new SearchHistory();
        searchHistoryList.add(searchHistory1);
        User user1 = new User(1, "Kasia", "Nowak", "kasia.nowak@o2.pl", "haslo123", 30, "K", "Kraków", "Polska", artistList, searchHistoryList);
        usersList.add(user1);
        UserDto userDto = new UserDto(1, "Anna", "Budzyń", "anna.budzyn@o2.pl", "haslo123", 32, "K", "Warszawa", "Polska", artistList, searchHistoryList);

        List<UserDto> usersDtoList = new ArrayList<>();
        usersDtoList.add(userDto);

        when(userMapperMock.mapToUserDtoList(usersList)).thenReturn(usersDtoList);
        when(dbUserServiceMock.getAllUsers()).thenReturn(usersList);

        //When

        List<UserDto> result = userFacade.getUsers();

        //Then

        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());

    }
}
