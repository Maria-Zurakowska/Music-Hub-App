package com.musichub.musichubapp.domain.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WikipediaResponseDto {

    private String batchcomplete;
    private WikiContinueDto wikiContinue;
    private WikiQueryDto query;
}
