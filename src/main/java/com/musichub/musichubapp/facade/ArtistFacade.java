package com.musichub.musichubapp.facade;

import com.musichub.musichubapp.domain.ArtistDto;
import com.musichub.musichubapp.mapper.ArtistMapper;
import com.musichub.musichubapp.service.DbArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistFacade {

    @Autowired
    private DbArtistService dbArtistService;

    @Autowired
    private ArtistMapper artistMapper;

    public List<ArtistDto> getArtists(){
            return artistMapper.mapToArtistDtoList(dbArtistService.getAllArtists());}

}
