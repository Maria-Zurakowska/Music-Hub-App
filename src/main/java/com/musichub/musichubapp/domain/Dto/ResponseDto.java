package com.musichub.musichubapp.domain.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDto {
    private final TicketMasterResponseDto tmMusicianInfo;
    private final SpotifyResponseDto spotifyMusicianInfo;
    private final WikipediaResponseDto wikiMusicianInfo;
    private final YouTubeResponseDto ytMusicianInfo;

    public ResponseDto(TicketMasterResponseDto tmMusicianInfo, SpotifyResponseDto spotifyMusicianInfo, WikipediaResponseDto wikiMusicianInfo, YouTubeResponseDto ytMusicianInfo) {
        this.tmMusicianInfo = tmMusicianInfo;
        this.spotifyMusicianInfo = spotifyMusicianInfo;
        this.wikiMusicianInfo = wikiMusicianInfo;
        this.ytMusicianInfo = ytMusicianInfo;

    }

}
