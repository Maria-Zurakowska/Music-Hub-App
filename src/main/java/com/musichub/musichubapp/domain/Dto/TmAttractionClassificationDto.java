package com.musichub.musichubapp.domain.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TmAttractionClassificationDto {

    private boolean primary;
    private boolean family;

    private TmAttractionClassificationSegmentDto segment;
    private TmAttractionClassificationGenreDto genre;
    private TmAttractionClassificationSubGenreDto subGenre;
    private TmAttractionClassificationTypeDto type;

}
