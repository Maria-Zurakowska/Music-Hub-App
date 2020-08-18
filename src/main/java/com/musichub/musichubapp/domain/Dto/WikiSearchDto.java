package com.musichub.musichubapp.domain.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WikiSearchDto {
    private int ns;
    private String title;
    private int pageid;
    private int size;
    private int wordcount;
    private String snippet;
    private String timestamp;
}
