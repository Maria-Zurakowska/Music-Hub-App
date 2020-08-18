package com.musichub.musichubapp.domain.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class YTSnippetDto {

    private String publishedAt;
    private String channelId;
    private String title;
    private String description;

    private YTThumbnailsDto thumbnails;

    private String channelTitle;
    private String liveBroadcastContent;
    private String publishTime;

}
