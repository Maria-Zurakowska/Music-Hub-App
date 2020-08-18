package com.musichub.musichubapp.client.youtube;

import com.musichub.musichubapp.domain.Dto.YouTubeResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class YouTubeClient {
    private final RestTemplate restTemplate;

    public YouTubeClient(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }

    public YouTubeResponseDto getMusicianInfo(String musician){
        String url = "https://www.googleapis.com/youtube/v3/search?key=AIzaSyAxB-EhsCnvo9Fl8wjU81aVHO1wyrmbSZc&part=snippet&q=" + musician;
        YouTubeResponseDto response = restTemplate.getForObject(url, YouTubeResponseDto.class);
        return response;
    }
}
