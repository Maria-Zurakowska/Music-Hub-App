package com.musichub.musichubapp.client;

import com.musichub.musichubapp.client.youtube.YouTubeClient;
import com.musichub.musichubapp.domain.Dto.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class YouTubeClientTestSuite {


    @Mock
    private RestTemplate restTemplateMock;

    private YouTubeClient youTubeClient;

    @Before
    public void setUp() {
        initMocks(this);
        youTubeClient = new YouTubeClient(restTemplateMock);
    }

    @Test
    public void testGetMusicianInfo(){

        //Given
        String musician = "Radiohead";
        String url = "https://www.googleapis.com/youtube/v3/search?key=AIzaSyAxB-EhsCnvo9Fl8wjU81aVHO1wyrmbSZc&part=snippet&q=" + musician;
        List<YTItemDto> ytItemDtoList = new ArrayList<>();
        ytItemDtoList.add(new YTItemDto("youtube#searchResult", "whCAnWAOz_YjJ5-8h8VAoptUJrI", new YTIdDto("youtube#channel", "UCq19-LqvG35A-30oyAiPiqA"),
                new YTSnippetDto("2005-10-08T15:10:46Z", "UCq19-LqvG35A-30oyAiPiqA", "Radiohead", "", new YTThumbnailsDto(), "Radiohead", "none", "2005-10-08T15:10:46Z")));
        YouTubeResponseDto responseDto = new YouTubeResponseDto("youtube#searchListResponse", "XYlTkSBmrDfOceG7IiLvbkUK2dg", "CAUQAA","PL", new YTPageInfoDto(1000000, 5), ytItemDtoList);
        when(restTemplateMock.getForObject(url, YouTubeResponseDto.class)).thenReturn(responseDto);

        //When

        YouTubeResponseDto result = youTubeClient.getMusicianInfo("Radiohead");

        //Then

       Assert.assertEquals("PL", result.getRegionCode());
       Assert.assertEquals("youtube#searchListResponse",result.getKind());
       Assert.assertEquals("XYlTkSBmrDfOceG7IiLvbkUK2dg", result.getEtag());
    }

    @Test
    public void testGetMusicianYouTubeChannel(){

        //Given

        String musician = "Radiohead";
        String url = "https://www.googleapis.com/youtube/v3/channels?part=snippet,contentDetails,statistics&forUsername=" + musician + "&key=AIzaSyAxB-EhsCnvo9Fl8wjU81aVHO1wyrmbSZc";
        List<YTItemDto> ytItemDtoList = new ArrayList<>();
        ytItemDtoList.add(new YTItemDto("youtube#searchResult", "whCAnWAOz_YjJ5-8h8VAoptUJrI", new YTIdDto("youtube#channel", "UCq19-LqvG35A-30oyAiPiqA"),
                new YTSnippetDto("2005-10-08T15:10:46Z", "UCq19-LqvG35A-30oyAiPiqA", "Radiohead", "", new YTThumbnailsDto(), "Radiohead", "none", "2005-10-08T15:10:46Z")));
        YouTubeResponseDto responseDto = new YouTubeResponseDto("youtube#searchListResponse", "XYlTkSBmrDfOceG7IiLvbkUK2dg", "CAUQAA","PL", new YTPageInfoDto(1000000, 5), ytItemDtoList);
        when(restTemplateMock.getForObject(url, YouTubeResponseDto.class)).thenReturn(responseDto);

        //When

        YouTubeResponseDto result = youTubeClient.getMusicianYouTubeChannel("Radiohead");

        //Then

        Assert.assertEquals("PL", result.getRegionCode());
        Assert.assertEquals("youtube#searchListResponse",result.getKind());
        Assert.assertEquals("XYlTkSBmrDfOceG7IiLvbkUK2dg", result.getEtag());
    }
}
