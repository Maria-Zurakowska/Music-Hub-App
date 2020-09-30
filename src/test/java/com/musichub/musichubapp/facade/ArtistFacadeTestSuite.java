package com.musichub.musichubapp.facade;

import com.musichub.musichubapp.domain.ArtistDto;
import com.musichub.musichubapp.entities.Artist;
import com.musichub.musichubapp.entities.User;
import com.musichub.musichubapp.mapper.ArtistMapper;
import com.musichub.musichubapp.service.DbArtistService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;

import java.util.List;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ArtistFacadeTestSuite {

    @InjectMocks
    private ArtistFacade artistFacade;

    @Mock
    private DbArtistService dbArtistServiceMock;

    @Mock
    private ArtistMapper artistMapperMock;

    @Test
    public void testGetArtists(){

        //Given

        List<User> usersList = new ArrayList<>();
        List<Artist> artistList = new ArrayList<>();
        List<ArtistDto> artistDtoList = new ArrayList<>();

        Artist artist1 = new Artist(1, "Madonna", "pop", usersList);
        artistList.add(artist1);

        ArtistDto artistDto = new ArtistDto(0, "Radiohead", "alternative rock", usersList);
        artistDtoList.add(artistDto);

        when(artistMapperMock.mapToArtistDtoList(artistList)).thenReturn(artistDtoList);
        when(dbArtistServiceMock.getAllArtists()).thenReturn(artistList);
        when(dbArtistServiceMock.getArtist(1)).thenReturn(java.util.Optional.of(artist1));

        //When

        List<ArtistDto> result = artistFacade.getArtists();

        //Then

        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        result.forEach( r -> {
            Assert.assertEquals(0, r.getId());
            Assert.assertEquals("Radiohead", r.getName());
        } );

    }


}
