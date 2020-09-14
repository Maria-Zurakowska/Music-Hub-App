package com.musichub.musichubapp.mapper;

import com.musichub.musichubapp.entities.ArtistGrade;
import com.musichub.musichubapp.domain.ArtistGradeDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArtistGradeMapper {

    public List<ArtistGradeDto> mapToArtistGradeDtoList (final List<ArtistGrade> artistGradesList){
        return artistGradesList.stream()
                .map(ag -> new ArtistGradeDto(ag.getId(), ag.getArtistName(), ag.getGrade() ))
                .collect(Collectors.toList());
    }

    public ArtistGradeDto mapToArtistGradeDto (final ArtistGrade artistGrade){
        return new ArtistGradeDto(
                artistGrade.getId(),
                artistGrade.getArtistName(),
                artistGrade.getGrade() );
    }
    public ArtistGrade mapToArtistGrade (final ArtistGradeDto artistGradeDto){
        return new ArtistGrade(
                artistGradeDto.getId(),
                artistGradeDto.getArtistName(),
                artistGradeDto.getGrade()
        );
    }
}
