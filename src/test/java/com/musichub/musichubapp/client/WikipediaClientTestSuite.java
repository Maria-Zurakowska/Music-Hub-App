package com.musichub.musichubapp.client;

import com.musichub.musichubapp.client.wikipedia.WikipediaClient;
import com.musichub.musichubapp.domain.Dto.WikiContinueDto;
import com.musichub.musichubapp.domain.Dto.WikiQueryDto;
import com.musichub.musichubapp.domain.Dto.WikipediaResponseDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class WikipediaClientTestSuite {

    @Mock
    private RestTemplate restTemplateMock;

    private WikipediaClient wikipediaClient;

    @Before
    public void setUp(){

        initMocks(this);
        wikipediaClient = new WikipediaClient(restTemplateMock);
    }

    @Test
    public void testGetMusicianInfo(){

        //Given

        String musician = "Radiohead";
        String url = "https://en.wikipedia.org/w/api.php?action=query&format=json&list=search&srsearch=" + musician;

        WikiContinueDto wikiContinueDto = new WikiContinueDto(10, "-||");
        WikiQueryDto wikiQueryDto = new WikiQueryDto();

        WikipediaResponseDto responseDto = new WikipediaResponseDto("", wikiContinueDto, wikiQueryDto);
        when(restTemplateMock.getForObject(url, WikipediaResponseDto.class)).thenReturn(responseDto);

        //When

        WikipediaResponseDto result = wikipediaClient.getMusicianInfo("Radiohead");

        //Then

        Assert.assertEquals( 10, result.getWikiContinue().getSroffset());
        Assert.assertEquals("-||", result.getWikiContinue().getWikiContinue());
    }
}
