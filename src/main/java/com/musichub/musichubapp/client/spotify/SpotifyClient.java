package com.musichub.musichubapp.client.spotify;

import com.musichub.musichubapp.domain.Dto.SpotifyResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SpotifyClient {

    private final RestTemplate restTemplate;

// https://api.spotify.com/v1/search?query=Lady+Gaga&offset=0&limit=20&type=artist
    // tak wygląda przykładowy adres. W argumencie metody wpisuję wartość w " ", np. "Rolling Stones",
    //a jak to będzie wyglądało z + czy %20 rozdzielającymi nazwę w String url?

    //Zapytanie do Spotify wymaga wygenerowania Tokena.

    public SpotifyClient(RestTemplate restTemplate){

        this.restTemplate = restTemplate;
    }
    public SpotifyResponseDto getMusicianInfo(String musician){
        String url = "https://api.spotify.com/v1/search?query=" + musician + "&offset=0&limit=20&type=artist";
        SpotifyResponseDto response = restTemplate.getForObject(url, SpotifyResponseDto.class);
        return response;
    }
}
