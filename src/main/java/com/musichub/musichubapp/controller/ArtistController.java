package com.musichub.musichubapp.controller;

import com.musichub.musichubapp.domain.ArtistDto;
import com.musichub.musichubapp.domain.ArtistGradeDto;
import com.musichub.musichubapp.domain.Dto.ResponseDto;
import com.musichub.musichubapp.domain.SearchHistoryDto;
import com.musichub.musichubapp.facade.ArtistFacade;
import com.musichub.musichubapp.mapper.ArtistGradeMapper;
import com.musichub.musichubapp.mapper.ArtistMapper;
import com.musichub.musichubapp.mapper.SearchHistoryMapper;
import com.musichub.musichubapp.service.ArtistService;
import com.musichub.musichubapp.service.DbArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @Autowired
    private ArtistFacade artistFacade;

    @Autowired
    private DbArtistService dbArtistService;

    @Autowired
    private ArtistMapper artistMapper;

    @Autowired
    private ArtistGradeMapper artistGradeMapper;

    @Autowired
    private SearchHistoryMapper searchHistoryMapper;

    @GetMapping("/{name}")
    public ResponseDto getArtistDetails(@PathVariable("name") String name) {
        return artistService.getDetails(name);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getArtists")
    public List<ArtistDto> getArtists() {
        return artistFacade.getArtists();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getArtist")
    public ArtistDto getArtist(@RequestParam Integer artistId) throws ArtistNotFoundException {
        return artistMapper.mapToArtistDto(dbArtistService.getArtist(artistId).orElseThrow(ArtistNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteArtist")
    public void deleteArtist(@RequestParam Integer artistId) {
        dbArtistService.deleteArtist(artistId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateArtist")
    public ArtistDto updateArtist(@RequestBody ArtistDto artistDto) {
        return artistMapper.mapToArtistDto(dbArtistService.saveArtist(artistMapper.mapToArtist(artistDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createArtist", consumes = APPLICATION_JSON_VALUE)
    public void createArtist(@RequestBody ArtistDto artistDto) {
        dbArtistService.saveArtist(artistMapper.mapToArtist(artistDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getAllArtistGrades")
    public List<ArtistGradeDto> getGrades() {
        return artistGradeMapper.mapToArtistGradeDtoList(dbArtistService.getAllArtistGrades());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getArtistGrade")
    public ArtistGradeDto getArtistGrade(@RequestParam Integer artistGradeId) throws ArtistGradeNotFoundException {
        return artistGradeMapper.mapToArtistGradeDto(dbArtistService.getArtistGrade(artistGradeId).orElseThrow(ArtistGradeNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteArtistGrade")
    public void deleteArtistGrade(@RequestParam Integer artistGradeId) {
        dbArtistService.deleteArtistGrade(artistGradeId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateArtistGrade")
    public ArtistGradeDto updateArtistGrade(@RequestBody ArtistGradeDto artistGradeDto) {
        return artistGradeMapper.mapToArtistGradeDto(dbArtistService.saveArtistGrade(artistGradeMapper.mapToArtistGrade(artistGradeDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createArtistGrade", consumes = APPLICATION_JSON_VALUE)
    public void createArtistGrade(@RequestBody ArtistGradeDto artistGradeDto) {
        dbArtistService.saveArtistGrade(artistGradeMapper.mapToArtistGrade(artistGradeDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getLast10Artist", consumes = APPLICATION_JSON_VALUE)
    public List<ArtistDto> getLast10Artists(@RequestParam int id) {
        return artistMapper.mapToArtistDtoList(dbArtistService.getLast10Artists(id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getLastArtistsByDay", consumes = APPLICATION_JSON_VALUE)
    public List<SearchHistoryDto> getLastArtistsByDay(@RequestParam LocalDate date) {
        return searchHistoryMapper.mapToSearchHistoryDtoList(dbArtistService.getLastArtistsByWhenSearched(date));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getLastArtistsByText", consumes = APPLICATION_JSON_VALUE)
    public List<SearchHistoryDto> getLastArtistsByText(@RequestParam String text) {
        return searchHistoryMapper.mapToSearchHistoryDtoList(dbArtistService.getLastArtistsByText(text));

    }
}