package com.musichub.musichubapp.mapper;

import com.musichub.musichubapp.entities.Artist;
import com.musichub.musichubapp.domain.ArtistDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArtistMapper {

    public List<ArtistDto> mapToArtistDtoList(final List<Artist> artistList) {
        return artistList.stream()
                .map(a -> new ArtistDto(a.getId(), a.getName(), a.getGenre(), a.getLikes() ))
                .collect(Collectors.toList());
    }

    public ArtistDto mapToArtistDto(final Artist artist) {
        return new ArtistDto(
                artist.getId(),
                artist.getName(),
                artist.getGenre(),
                artist.getLikes());
    }

    public Artist mapToArtist(final ArtistDto artistDto) {
        return new Artist(
                artistDto.getId(),
                artistDto.getName(),
                artistDto.getGenre(),
                artistDto.getLikes());
    }

    }

