package com.musichub.musichubapp.domain.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TmEventDto {
    private String name;
    private String type;
    private String id;
    private boolean test;
    private String url;
    private String locale;

    private List<TmImageDto> images;

    private TmSaleDto sales;
    private TmDateDto dates;
    private List<TmPriceRangeDto> priceRanges;
    private TmSeatMapDto seatMap;
    private TmTicketLimitDto ticketLimit;
    //private TmAgeRestrictions ageRestrictions;
    private TmEventEmbeddedDto _embedded;



}
