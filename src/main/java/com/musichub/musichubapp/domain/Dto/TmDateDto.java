package com.musichub.musichubapp.domain.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TmDateDto {

    private TmDateStartDto start;
    private TmDateStatusDto status;
    private String timezone;
    private boolean spanMultipleDays;
}
