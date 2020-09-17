package com.musichub.musichubapp.mapper;

import com.musichub.musichubapp.domain.SearchHistoryDto;
import com.musichub.musichubapp.entities.Artist;
import com.musichub.musichubapp.entities.SearchHistory;
import com.musichub.musichubapp.entities.User;
import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SearchHistoryMapperTestSuite {

    private SearchHistoryMapper searchHistoryMapper = new SearchHistoryMapper();

    @Test
    public void testMapToSearchHistoryDtoList() {

        // Given

        List<User> usersList = new ArrayList<>();
        List<Artist> artistList = new ArrayList<>();
        Artist artist = new Artist(0, "Radiohead", "alternative rock", usersList);
        artistList.add(artist);
        List<SearchHistory> searchHistoryList = new ArrayList<>();
        User user1 = new User(0, "Kasia", "Nowak", "kasia.nowak@o2.pl", "haslo123", 30, "K", "Kraków", "Polska", artistList, searchHistoryList);
        User user2 = new User(1, "Anna", "Budzyń", "anna.budzyn@gmail.com", "kwiatek1!", 35, "K", "Łódź", "Polska", artistList, searchHistoryList);
        searchHistoryList.add(new SearchHistory(0, "Radiohead", user1, LocalDate.of(2020, 9, 15)));
        searchHistoryList.add(new SearchHistory(1, "Nirvana", user2, LocalDate.of(2020,9,17)));

        // When

        List<SearchHistoryDto> searchHistoryDtoList = searchHistoryMapper.mapToSearchHistoryDtoList(searchHistoryList);

        // Then

        Assert.assertEquals(2, searchHistoryDtoList.size());
        Assert.assertEquals(searchHistoryList.size(), searchHistoryDtoList.size());
        Assert.assertEquals(searchHistoryList.get(0).getId(), searchHistoryDtoList.get(0).getId());
        Assert.assertEquals(searchHistoryList.get(0).getSearchedWord(), searchHistoryDtoList.get(0).getSearchedWord());
        Assert.assertEquals(searchHistoryList.get(0).getWhenSearched(), searchHistoryDtoList.get(0).getWhenSearched());
    }

    @Test
    public void testMapToSearchHistoryDto() {

        // Given

        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();
        User user1 = new User(0, "Kasia", "Nowak", "kasia.nowak@o2.pl", "haslo123", 30, "K", "Kraków", "Polska", artistList, searchHistoryList);
        User user2 = new User(1, "Anna", "Budzyń", "anna.budzyn@gmail.com", "kwiatek1!", 35, "K", "Łódź", "Polska", artistList, searchHistoryList);

        SearchHistory searchHistory = new SearchHistory(0, "Radiohead", user1, LocalDate.of(2020, 9, 15));

        // When

        SearchHistoryDto searchHistoryDto = searchHistoryMapper.mapToSearchHistoryDto(searchHistory);

        // Then

        Assert.assertNotNull(searchHistoryDto);
        Assert.assertEquals("Radiohead", searchHistoryDto.getSearchedWord());
        Assert.assertEquals(user1, searchHistoryDto.getUser());
    }

    @Test
    public void testMapToSearchHistory() {

        // Given

        List<Artist> artistList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();
        User user1 = new User(0, "Kasia", "Nowak", "kasia.nowak@o2.pl", "haslo123", 30, "K", "Kraków", "Polska", artistList, searchHistoryList);
        User user2 = new User(1, "Anna", "Budzyń", "anna.budzyn@gmail.com", "kwiatek1!", 35, "K", "Łódź", "Polska", artistList, searchHistoryList);


        SearchHistoryDto searchHistoryDto = new SearchHistoryDto(0, "Radiohead", user2, LocalDate.of(2020,9, 9));

        // When

        SearchHistory searchHistory = searchHistoryMapper.mapToSearchHistory(searchHistoryDto);

        // Then

        Assert.assertEquals("Radiohead", searchHistory.getSearchedWord());
        Assert.assertEquals(searchHistoryDto.getId(), searchHistory.getId());
        Assert.assertEquals(user2, searchHistory.getUser());
    }
}
