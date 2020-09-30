package com.musichub.musichubapp.client;

import com.musichub.musichubapp.client.spotify.SpotifyClient;
import com.musichub.musichubapp.domain.Dto.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.Mockito.when;

public class SpotifyClientTestSuite {

    @Mock
    private RestTemplate restTemplateMock;

    private SpotifyClient spotifyClient;

    @Before
    public void setUp(){

        initMocks(this);
        spotifyClient = new SpotifyClient(restTemplateMock);
    }

    @Test
    public void testGetMusicianInfo(){

        //Given

        String musician = "Radiohead";
        String url = "https://api.spotify.com/v1/search?query=" + musician + "&offset=0&limit=20&type=artist";

        SpotifyExternalUrlsDto external_urls = new SpotifyExternalUrlsDto("https://open.spotify.com/artist/4Z8W4fKeB5YxbusRsdQVPb");
        SpotifyFollowersDto followers = new SpotifyFollowersDto(2, 5466421);

        List<String> genres = new ArrayList<>();
        genres.add("alternative rock");
        genres.add("alt rock");
        genres.add("oxford indie");
        genres.add("permanent wave");

        List<SpotifyGenreDto> spotifyGenreDtoList = new ArrayList<>();
        spotifyGenreDtoList.add(new SpotifyGenreDto(genres));


        String spotifyItemDtoHref = "https://api.spotify.com/v1/artists/4Z8W4fKeB5YxbusRsdQVPb";
        String id = "4Z8W4fKeB5YxbusRsdQVPb";

        List<SpotifyImageDto> images = new ArrayList<>();

        String name = "Radiohead";
        int popularity = 81;
        String artist = "";
        String uri = "spotify:artist:4Z8W4fKeB5YxbusRsdQVPb";

        SpotifyItemDto spotifyItemDto1 = new SpotifyItemDto(external_urls, followers, spotifyGenreDtoList, spotifyItemDtoHref, id, images, name, popularity, artist, uri);

        String spotifyArtistDtoHref = "https://api.spotify.com/v1/search?query=Radiohead&type=artist&offset=0&limit=20";
        List<SpotifyItemDto> items = new ArrayList<>();
        items.add(spotifyItemDto1);

        SpotifyArtistDto spotifyArtistDto = new SpotifyArtistDto(spotifyArtistDtoHref, items);

        SpotifyResponseDto responseDto = new SpotifyResponseDto(spotifyArtistDto);
        when(restTemplateMock.getForObject(url, SpotifyResponseDto.class)).thenReturn(responseDto);

        //When

        SpotifyResponseDto result = spotifyClient.getMusicianInfo("Radiohead");

        //Then
        Assert.assertEquals("https://api.spotify.com/v1/search?query=Radiohead&type=artist&offset=0&limit=20", result.getArtists().getHref());

    }
}
