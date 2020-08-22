package com.musichub.musichubapp.controller;

import com.musichub.musichubapp.domain.ArtistDto;
import com.musichub.musichubapp.domain.ArtistGradeDto;
import com.musichub.musichubapp.domain.Dto.ResponseDto;
import com.musichub.musichubapp.mapper.ArtistGradeMapper;
import com.musichub.musichubapp.mapper.ArtistMapper;
import com.musichub.musichubapp.service.ArtistService;
import com.musichub.musichubapp.service.DbArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/artist")
public class ArtistController { 

    @Autowired
    private ArtistService artistService;

    @Autowired
    private DbArtistService dbArtistService;

    @Autowired
    private ArtistMapper artistMapper;

    @Autowired
    private ArtistGradeMapper artistGradeMapper;

    @GetMapping("/{name}")
    public ResponseDto getArtistDetails(@PathVariable("name") String name){
        return artistService.getDetails(name);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getArtists")
    public List<ArtistDto> getArtists(){

        return artistMapper.mapToArtistDtoList(dbArtistService.getAllArtists());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getArtist")
    public ArtistDto getArtist(@RequestParam Integer artistId) throws ArtistNotFoundException {
        return artistMapper.mapToArtistDto(dbArtistService.getArtist(artistId).orElseThrow(ArtistNotFoundException::new));
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteArtist")
        public void deleteArtist(@RequestParam Integer artistId){
            dbArtistService.deleteArtist(artistId);
        }

    @RequestMapping(method = RequestMethod.PUT, value = "updateArtist")
    public ArtistDto updateArtist(@RequestBody ArtistDto artistDto){
        return artistMapper.mapToArtistDto(dbArtistService.saveArtist(artistMapper.mapToArtist(artistDto)));
    }
    @RequestMapping(method = RequestMethod.POST, value = "createArtist", consumes = APPLICATION_JSON_VALUE)
    public void createArtist(@RequestBody ArtistDto artistDto){
        dbArtistService.saveArtist(artistMapper.mapToArtist(artistDto));
    }


    @RequestMapping(method = RequestMethod.GET, value = "getAllArtistGrades")
    public List<ArtistGradeDto> getGrades(){
        return artistGradeMapper.mapToArtistGradeDtoList(dbArtistService.getAllArtistGrades());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getArtistGrade")
    public ArtistGradeDto getArtistGrade(@RequestParam Integer artistGradeId) throws ArtistGradeNotFoundException{
        return artistGradeMapper.mapToArtistGradeDto(dbArtistService.getArtistGrade(artistGradeId).orElseThrow(ArtistGradeNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteArtistGrade")
    public void deleteArtistGrade(@RequestParam Integer artistGradeId) {
        dbArtistService.deleteArtistGrade(artistGradeId);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "updateArtistGrade")
    public ArtistGradeDto updateArtistGrade(@RequestBody ArtistGradeDto artistGradeDto){
        return artistGradeMapper.mapToArtistGradeDto(dbArtistService.saveArtistGrade(artistGradeMapper.mapToArtistGrade(artistGradeDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createArtistGrade", consumes = APPLICATION_JSON_VALUE)
    public void createArtistGrade(@RequestBody ArtistGradeDto artistGradeDto){
        dbArtistService.saveArtistGrade(artistGradeMapper.mapToArtistGrade(artistGradeDto));
    }


}
