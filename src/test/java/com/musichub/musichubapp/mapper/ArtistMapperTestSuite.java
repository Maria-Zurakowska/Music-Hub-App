package com.musichub.musichubapp.mapper;

import com.musichub.musichubapp.domain.ArtistDto;
import com.musichub.musichubapp.entities.Artist;
import com.musichub.musichubapp.entities.SearchHistory;
import com.musichub.musichubapp.entities.User;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class ArtistMapperTestSuite {

    private ArtistMapper artistMapper = new ArtistMapper();

    @Test
    public void testMapToArtistDtoList() {

        // Given

        List<User> usersList = new ArrayList<>();
        List<Artist> artistList = new ArrayList<>();
        artistList.add(new Artist(0, "Radiohead", "alternative rock", usersList));
        artistList.add(new Artist(1, "Nirvana", "grunge", usersList));

        List<SearchHistory> searchHistoryList = new ArrayList<>();
        User user1 = new User(1, "Kasia", "Nowak", "kasia.nowak@o2.pl", "haslo123", 30, "K", "Kraków", "Polska", artistList, searchHistoryList);
        usersList.add(user1);

        // When

        List<ArtistDto> artistDtoList = artistMapper.mapToArtistDtoList(artistList);

        // Then

        Assert.assertEquals(2, artistDtoList.size());
        Assert.assertEquals(artistList.size(), artistDtoList.size());
        Assert.assertEquals(artistList.get(0).getId(), artistDtoList.get(0).getId());
        Assert.assertEquals(artistList.get(0).getName(), artistDtoList.get(0).getName());
        Assert.assertEquals(artistList.get(0).getGenre(), artistDtoList.get(0).getGenre());
    }

    @Test
    public void testMapToArtistDto() {

        // Given

        List<User> usersList = new ArrayList<>();
        List<SearchHistory> searchHistoryList = new ArrayList<>();
        List<Artist> artistList = new ArrayList<>();
        Artist artist = new Artist(0, "Radiohead", "alternative rock", usersList);
        artistList.add(artist);

        User user1 = new User(1, "Kasia", "Nowak", "kasia.nowak@o2.pl", "haslo123", 30, "K", "Kraków", "Polska", artistList, searchHistoryList);
        usersList.add(user1);

        // When

        ArtistDto artistDto = artistMapper.mapToArtistDto(artist);

        // Then

        Assert.assertNotNull(artistDto);
        Assert.assertEquals("Radiohead", artistDto.getName());
        Assert.assertEquals("alternative rock", artistDto.getGenre());
    }

    @Test
    public void testMapToArtist() {

        // Given

        List<User> usersList = new ArrayList<>();
        List<Artist> artistList = new ArrayList<>();
        Artist artist = new Artist(1, "Radiohead", "alternative rock", usersList);
        artistList.add(artist);

        ArtistDto artistDto = new ArtistDto(1, "Nirvana", "grunge", usersList);

        // When

        Artist result = artistMapper.mapToArtist(artistDto);

        // Then

        Assert.assertEquals("Radiohead", artist.getName());
        Assert.assertEquals(artistDto.getId(), artist.getId());
        Assert.assertEquals("alternative rock", artist.getGenre());
    }
}
