package com.musichub.musichubapp.domain.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TmSalePublicDto {
    private String startDateTime;
    private boolean startTBD;
    private boolean startTBA;
    private String endDateTime;

}
