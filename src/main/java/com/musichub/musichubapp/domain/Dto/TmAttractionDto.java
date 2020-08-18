package com.musichub.musichubapp.domain.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TmAttractionDto {
    private String name;
    private String type;
    private String id;
    private boolean test;
    private String url;
    private String locale;
    private TmAttractionExternalLinksDto externalLinks;
    private List<TmAttractionClassificationDto> classifications;
    private TmAttractionUpcomingEventsDto upcomingEvents;
}
