package com.musichub.musichubapp.mapper;

import com.musichub.musichubapp.domain.SearchHistoryDto;
import com.musichub.musichubapp.entities.SearchHistory;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class SearchHistoryMapper {

    public List<SearchHistoryDto> mapToSearchHistoryDtoList(final List<SearchHistory> searchHistoryList) {
        return searchHistoryList.stream()
                .map(a -> new SearchHistoryDto(a.getId(), a.getSearchedWord(),a.getUser(),a.getWhenSearched()))
                .collect(Collectors.toList());
    }

    public SearchHistoryDto mapToSearchHistoryDto(final SearchHistory searchHistory) {
        return new SearchHistoryDto(
                searchHistory.getId(),
                searchHistory.getSearchedWord(),
                searchHistory.getUser(),
                searchHistory.getWhenSearched());
    }

    public SearchHistory mapToSearchHistory(final SearchHistoryDto searchHistoryDto) {
        return new SearchHistory(
                searchHistoryDto.getId(),
                searchHistoryDto.getSearchedWord(),
                searchHistoryDto.getUser(),
                searchHistoryDto.getWhenSearched());
    }
}

