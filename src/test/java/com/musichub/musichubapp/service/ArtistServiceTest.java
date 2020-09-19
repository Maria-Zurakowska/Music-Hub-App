package com.musichub.musichubapp.service;

import com.musichub.musichubapp.client.spotify.SpotifyClient;
import com.musichub.musichubapp.client.ticketmaster.TicketMasterClient;
import com.musichub.musichubapp.client.wikipedia.WikipediaClient;
import com.musichub.musichubapp.client.youtube.YouTubeClient;
import com.musichub.musichubapp.domain.Dto.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ArtistServiceTest {

    @Mock
    private TicketMasterClient tmClientMock;
    @Mock
    private SpotifyClient spotifyClientMock;
    @Mock
    private WikipediaClient wikipediaClientMock;
    @Mock
    private YouTubeClient youTubeClientMock;

    @InjectMocks
    private ArtistService artistService;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testGetDetails() {

        // Given

        TicketMasterResponseDto ticketMasterResponseDto = new TicketMasterResponseDto();
        when(tmClientMock.getMusicianInfo("Radiohead")).thenReturn(ticketMasterResponseDto);

        SpotifyResponseDto spotifyResponseDto = new SpotifyResponseDto();
        when(spotifyClientMock.getMusicianInfo("Radiohead")).thenReturn(spotifyResponseDto);

        WikipediaResponseDto wikipediaResponseDto = new WikipediaResponseDto();
        when(wikipediaClientMock.getMusicianInfo("Radiohead")).thenReturn(wikipediaResponseDto);

        YouTubeResponseDto youTubeResponseDto = new YouTubeResponseDto();
        when(youTubeClientMock.getMusicianInfo("Radiohead")).thenReturn(youTubeResponseDto);

        // When

        ResponseDto result = artistService.getDetails("Radiohead");

        // Then

        Assert.assertNotNull(result);
        verify(tmClientMock).getMusicianInfo("Radiohead");
    }
}
