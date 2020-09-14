package com.musichub.musichubapp.domain.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ResponseDto {
    private final TicketMasterResponseDto tmMusicianInfo;
    private final SpotifyResponseDto spotifyMusicianInfo;
    private final WikipediaResponseDto wikiMusicianInfo;
    private final YouTubeResponseDto ytMusicianInfo;

    public static class ResponseDtoBuilder {

        private TicketMasterResponseDto tmMusicianInfo;
        private SpotifyResponseDto spotifyMusicianInfo;
        private WikipediaResponseDto wikiMusicianInfo;
        private YouTubeResponseDto ytMusicianInfo;

        public ResponseDtoBuilder tmMusicianInfo(TicketMasterResponseDto tmMusicianInfo){
            this.tmMusicianInfo = tmMusicianInfo;
            return this;
        }
        public ResponseDtoBuilder spotifyMusicianInfo(SpotifyResponseDto spotifyMusicianInfo){
            this.spotifyMusicianInfo = spotifyMusicianInfo;
            return this;
        }

        public ResponseDtoBuilder wikiMusicianInfo(WikipediaResponseDto wikiMusicianInfo){
            this.wikiMusicianInfo = wikiMusicianInfo;
            return this;
        }

        public ResponseDtoBuilder ytMusicianInfo(YouTubeResponseDto ytMusicianInfo){
            this.ytMusicianInfo = ytMusicianInfo;
            return this;
        }
        public ResponseDto build(){
            return new ResponseDto(tmMusicianInfo, spotifyMusicianInfo, wikiMusicianInfo, ytMusicianInfo);
        }

    }

    public ResponseDto(final TicketMasterResponseDto tmMusicianInfo, final SpotifyResponseDto spotifyMusicianInfo, final WikipediaResponseDto wikiMusicianInfo, final YouTubeResponseDto ytMusicianInfo) {
        this.tmMusicianInfo = tmMusicianInfo;
        this.spotifyMusicianInfo = spotifyMusicianInfo;
        this.wikiMusicianInfo = wikiMusicianInfo;
        this.ytMusicianInfo = ytMusicianInfo;

    }
    
    public TicketMasterResponseDto getTmMusicianInfo() {
        return tmMusicianInfo;
    }

    public SpotifyResponseDto getSpotifyMusicianInfo() {
        return spotifyMusicianInfo;
    }

    public WikipediaResponseDto getWikiMusicianInfo() {
        return wikiMusicianInfo;
    }

    public YouTubeResponseDto getYtMusicianInfo() {
        return ytMusicianInfo;
    }
}
