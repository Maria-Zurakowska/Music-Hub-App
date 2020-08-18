package com.musichub.musichubapp.domain.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class YTThumbnailsDto {

    private YTThumbnailsDefaultDto thumbnailsDefault;
    private YTThumbnailsMediumDto medium;
    private YTThumbnailsHighDto high;
}
