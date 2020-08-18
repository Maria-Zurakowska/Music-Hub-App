package com.musichub.musichubapp.domain.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpotifyItemDto {

    private SpotifyExternalUrlsDto external_urls;
    private SpotifyFollowersDto followers;

    private List<SpotifyGenreDto> genres;

    private String href;
    private String id;

    private List<SpotifyImageDto> images;

    private String name;
    private int popularity;
    private String artist;
    private String uri;
}
