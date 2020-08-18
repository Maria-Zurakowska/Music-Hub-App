package com.musichub.musichubapp.domain.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TmAttractionUpcomingEventsDto {
    private int _total;
    private int mfx_nl;
    private int mfx_de;
    private int ticketmaster;
    private int mfx_cz;
    private int mfx_pl;
}
