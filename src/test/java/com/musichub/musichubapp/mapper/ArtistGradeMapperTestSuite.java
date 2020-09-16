package com.musichub.musichubapp.mapper;

import com.musichub.musichubapp.domain.ArtistGradeDto;
import com.musichub.musichubapp.entities.ArtistGrade;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

import java.util.List;

public class ArtistGradeMapperTestSuite {

    private ArtistGradeMapper artistGradeMapper = new ArtistGradeMapper();

    @Test
    public void testMapToArtistGradeDtoList() {

        // Given

        List<ArtistGrade> artistGradesList = new ArrayList<>();
        artistGradesList.add(new ArtistGrade(0, "Radiohead", 5));
        artistGradesList.add(new ArtistGrade(1, "Nirvana", 5));

        // When

        List<ArtistGradeDto> artistGradeDtoList = artistGradeMapper.mapToArtistGradeDtoList(artistGradesList);

        // Then

        Assert.assertEquals(2, artistGradeDtoList.size());
        Assert.assertEquals(artistGradesList.size(), artistGradeDtoList.size());
        Assert.assertEquals(artistGradesList.get(0).getId(), artistGradeDtoList.get(0).getId());
        Assert.assertEquals(artistGradesList.get(0).getArtistName(), artistGradeDtoList.get(0).getArtistName());
        Assert.assertEquals(artistGradesList.get(0).getGrade(), artistGradeDtoList.get(0).getGrade());

    }

    @Test
    public void testMapToArtistGradeDto() {

        // Given

        ArtistGrade artistGrade = new ArtistGrade(0, "Radiohead", 5);

        // When

        ArtistGradeDto artistGradeDto = artistGradeMapper.mapToArtistGradeDto(artistGrade);

        // Then
        Assert.assertNotNull(artistGradeDto);
        Assert.assertEquals("Radiohead", artistGradeDto.getArtistName());
        Assert.assertEquals(5, artistGradeDto.getGrade());

    }

    @Test
    public void testMapToArtistGrade() {

        // Given

        ArtistGradeDto artistGradeDto = new ArtistGradeDto(0, "Radiohead", 5);

        // When

        ArtistGrade artistGrade = artistGradeMapper.mapToArtistGrade(artistGradeDto);

        // Then

        Assert.assertEquals("Radiohead", artistGrade.getArtistName());
        Assert.assertEquals(artistGradeDto.getId(), artistGrade.getId());
        Assert.assertEquals(5, artistGrade.getGrade());
    }
}
