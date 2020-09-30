package com.musichub.musichubapp.domain.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TicketMasterResponseDto {

    private TmEmbeddedDto _embedded;
    private TmEmbeddedDto _links;

}
