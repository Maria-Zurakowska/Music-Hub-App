package com.musichub.musichubapp.client.ticketmaster;

import com.musichub.musichubapp.domain.Dto.TicketMasterResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TicketMasterClient {
    private final RestTemplate restTemplate;

    public TicketMasterClient(RestTemplate restTemplate){

        this.restTemplate = restTemplate;
    }
    public TicketMasterResponseDto getMusicianInfo(String musician){
        String url = "https://app.ticketmaster.com/discovery/v2/events?apikey=ndtkknvZK0Ib1P1DJPd8hI5UdGAwr7LG&keyword=" + musician + "&locale=*&countryCode=US";
        TicketMasterResponseDto response = restTemplate.getForObject(url, TicketMasterResponseDto.class);
        return response;
    }
}
