package com.musichub.musichubapp.service;

import com.musichub.musichubapp.client.spotify.SpotifyClient;
import com.musichub.musichubapp.client.ticketmaster.TicketMasterClient;
import com.musichub.musichubapp.client.wikipedia.WikipediaClient;
import com.musichub.musichubapp.client.youtube.YouTubeClient;
import com.musichub.musichubapp.domain.Dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {

    @Autowired
    private TicketMasterClient tmclient;
    @Autowired
    private SpotifyClient spotifyClient;
    @Autowired
    private WikipediaClient wikipediaClient;
    @Autowired
    private YouTubeClient youTubeClient;


    public ResponseDto getDetails(String name) {
        TicketMasterResponseDto tmMusicianInfo = tmclient.getMusicianInfo(name);

        SpotifyResponseDto spotifyMusicianInfo = spotifyClient.getMusicianInfo(name);

        WikipediaResponseDto wikiMusicianInfo = wikipediaClient.getMusicianInfo(name);

        YouTubeResponseDto ytMusicianInfo = youTubeClient.getMusicianInfo(name);

        return new ResponseDto(tmMusicianInfo,spotifyMusicianInfo,wikiMusicianInfo,ytMusicianInfo);
    }

}
