package com.musichub.musichubapp.domain.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TmVenueDto {

    private String name;
    private String type;
    private String id;
    private boolean test;
    private String url;
    private String locale;

    List<TmVenueImageDto> images;

    private String postalCode;
    private String timezone;
    private TmVenueCityDto city;
    private TmVenueStateDto state;
    private TmVenueCountryDto country;
    private TmVenueAddressDto address;
    private TmVenueLocationDto location;
    private TmVenueUpcomingEventsDto upcomingEvents;

}
