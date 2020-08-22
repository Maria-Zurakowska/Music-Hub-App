package com.musichub.musichubapp.client.spotify;

import com.musichub.musichubapp.domain.Dto.SpotifyResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SpotifyClient {

    private final RestTemplate restTemplate;

    public SpotifyClient(RestTemplate restTemplate){

        this.restTemplate = restTemplate;
    }
    public SpotifyResponseDto getMusicianInfo(String musician){
        String url = "https://api.spotify.com/v1/search?query=" + musician + "&offset=0&limit=20&type=artist";
        SpotifyResponseDto response = restTemplate.getForObject(url, SpotifyResponseDto.class);
        return response;
    }

//    --to be developed--
//    public SpotifyResponseDto getMusicianAlbums(String musicianID){
//        String url = "https://api.spotify.com/v1/artists/musicianID/albums";
//        SpotifyAlbumDto response = restTemplate.getForObject(url,SpotifyResponseDto.class);
//        return response;
//    }
}
