package com.musichub.musichubapp.client.wikipedia;

import com.musichub.musichubapp.domain.Dto.WikipediaResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WikipediaClient {
    private final RestTemplate restTemplate;

    public WikipediaClient(RestTemplate restTemplate){

        this.restTemplate = restTemplate;
    }
    public WikipediaResponseDto getMusicianInfo(String musician){
        String url = "https://en.wikipedia.org/w/api.php?action=query&format=json&list=search&srsearch=" + musician;
        WikipediaResponseDto response = restTemplate.getForObject(url, WikipediaResponseDto.class);
        return response;
    }
}
