package com.musichub.musichubapp.domain.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TmAttractionExternalLinksDto {

    private List<TmAttractionExternalLinksItunesDto> itunes;
    private List<TmAttractionExternalLinksLastFmDto> lastFm;
    private List<TmAttractionExternalLinksInstagramDto> instagram;
    private List<TmAttractionExternalLinksHomepageDto> homepage;

}
