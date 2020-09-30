package com.musichub.musichubapp.client;

import com.musichub.musichubapp.client.ticketmaster.TicketMasterClient;
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

public class TicketMasterClientTestSuite {

    @Mock
    private RestTemplate restTemplateMock;

    private TicketMasterClient ticketMasterClient;

    @Before
    public void setUp(){

        initMocks(this);
        ticketMasterClient = new TicketMasterClient(restTemplateMock);
    }

    @Test
    public void testGetMusicianInfo(){

        //Given

        String musician = "Radiohead";
        String url = "https://app.ticketmaster.com/discovery/v2/events?apikey=ndtkknvZK0Ib1P1DJPd8hI5UdGAwr7LG&keyword=" + musician + "&locale=*";

        List<TmImageDto> images = new ArrayList<>();

        List<TmEventDto> events1 = new ArrayList<>();
        List<TmEventDto> events2 = new ArrayList<>();

        TmSaleDto sales = new TmSaleDto(new TmSalePublicDto("2019-10-07T09:00:00Z", false, false, "2021-01-29T19:30:00Z"));
        TmDateDto dates = new TmDateDto();

        List<TmPriceRangeDto> tmPriceRangeDtoList = new ArrayList<>();

        TmSeatMapDto tmSeatMapDto = new TmSeatMapDto();
        TmTicketLimitDto ticketLimit = new TmTicketLimitDto();
        TmEventEmbeddedDto _embedded = new TmEventEmbeddedDto();

        TmEventDto tmEventDto1 = new TmEventDto("Karma Police- Radiohead Tribute Rescheduled", "event", "1AwZAqdGkeB9ITe", false, "https://www.ticketweb.ie/event/karma-police-radiohead-tribute-the-grand-social-tickets/9963725?REFERRAL_ID=tmfeed",
                "en-us", images, sales, dates, tmPriceRangeDtoList, tmSeatMapDto,ticketLimit, _embedded);
        TmEventDto tmEventDto2 = new TmEventDto("Radiohead - the tour", "event", "1AwZB473keB9ITe", false, "https://www.ticketweb.ie/event/radiohead-theTour-the-grand-social-tickets/9963725?REFERRAL_ID=tmfeed",
                "en-us", images, sales, dates, tmPriceRangeDtoList, tmSeatMapDto,ticketLimit, _embedded);

        events1.add((tmEventDto1));
        events2.add(tmEventDto2);

        TmEmbeddedDto emb1 = new TmEmbeddedDto(events1);
        TmEmbeddedDto emb2 = new TmEmbeddedDto(events2);

        TicketMasterResponseDto responseDto = new TicketMasterResponseDto(emb1, emb2);

        when(restTemplateMock.getForObject(url, TicketMasterResponseDto.class)).thenReturn(responseDto);

        // When

        TicketMasterResponseDto result = ticketMasterClient.getMusicianInfo("Radiohead");

        // Then

        Assert.assertEquals(1, result.get_embedded().getEvents().size());
    }

    @Test
    public void testGetMusicianVenuesByCountry(){

        // Given

        String musician = "Radiohead";
        String url = "https://app.ticketmaster.com/discovery/v2/events?apikey=ndtkknvZK0Ib1P1DJPd8hI5UdGAwr7LG&keyword=" + musician + "&locale=*&countryCode=PL";

        List<TmImageDto> images = new ArrayList<>();

        List<TmEventDto> events1 = new ArrayList<>();
        List<TmEventDto> events2 = new ArrayList<>();

        TmSaleDto sales = new TmSaleDto(new TmSalePublicDto("2019-10-07T09:00:00Z", false, false, "2021-01-29T19:30:00Z"));
        TmDateDto dates = new TmDateDto();

        List<TmPriceRangeDto> tmPriceRangeDtoList = new ArrayList<>();

        TmSeatMapDto tmSeatMapDto = new TmSeatMapDto();
        TmTicketLimitDto ticketLimit = new TmTicketLimitDto();
        TmEventEmbeddedDto _embedded = new TmEventEmbeddedDto();

        TmEventDto tmEventDto1 = new TmEventDto("Karma Police- Radiohead Tribute Rescheduled", "event", "1AwZAqdGkeB9ITe", false, "https://www.ticketweb.ie/event/karma-police-radiohead-tribute-the-grand-social-tickets/9963725?REFERRAL_ID=tmfeed",
                "en-us", images, sales, dates, tmPriceRangeDtoList, tmSeatMapDto,ticketLimit, _embedded);
        TmEventDto tmEventDto2 = new TmEventDto("Radiohead - the tour", "event", "1AwZB473keB9ITe", false, "https://www.ticketweb.ie/event/radiohead-theTour-the-grand-social-tickets/9963725?REFERRAL_ID=tmfeed",
                "en-us", images, sales, dates, tmPriceRangeDtoList, tmSeatMapDto,ticketLimit, _embedded);

        events1.add((tmEventDto1));
        events2.add(tmEventDto2);

        TmEmbeddedDto emb1 = new TmEmbeddedDto(events1);
        TmEmbeddedDto emb2 = new TmEmbeddedDto(events2);

        TicketMasterResponseDto responseDto = new TicketMasterResponseDto(emb1, emb2);
        when(restTemplateMock.getForObject(url, TicketMasterResponseDto.class)).thenReturn(responseDto);

        // When

        TicketMasterResponseDto result = ticketMasterClient.getMusicianVenuesByCountry("Radiohead");

        // Then
       Assert.assertEquals(1, result.get_embedded().getEvents().size());
       Assert.assertEquals(1, result.get_links().getEvents().size());
    }
}
