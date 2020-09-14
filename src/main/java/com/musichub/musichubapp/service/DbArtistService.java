package com.musichub.musichubapp.service;

import com.musichub.musichubapp.entities.Artist;
import com.musichub.musichubapp.entities.ArtistGrade;
import com.musichub.musichubapp.entities.SearchHistory;
import com.musichub.musichubapp.repository.ArtistGradeRepository;
import com.musichub.musichubapp.repository.ArtistRepository;
import com.musichub.musichubapp.repository.SearchHistoryRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DbArtistService {


    private final ArtistRepository artistRepository;
    private final ArtistGradeRepository artistGradeRepository;
    private final SearchHistoryRepository searchHistoryRepository;


    public List<Artist> getAllArtists(){

        return artistRepository.findAll();
    }

    public Optional<Artist> getArtist(Integer id){

        return artistRepository.findById(id);
    }
    public Artist saveArtist(final Artist artist){

        return artistRepository.save(artist);
    }
    public void deleteArtist(Integer id){

        artistRepository.deleteById(id);
    }

    public List<ArtistGrade> getAllArtistGrades(){

        return artistGradeRepository.findAll();
    }

    public Optional<ArtistGrade> getArtistGrade(Integer id){

        return artistGradeRepository.findById(id);
    }

    public ArtistGrade saveArtistGrade(final ArtistGrade artistGrade){

        return  artistGradeRepository.save(artistGrade);
    }
    public void deleteArtistGrade(Integer id){

        artistGradeRepository.deleteById(id);
    }

    public List<Artist> getLast10Artists(int id){

        return artistRepository.findFirstById(id);
    }

    public List<SearchHistory> getLastArtistsByWhenSearched(LocalDate date) {

        return searchHistoryRepository.findAllByWhenSearched(date);
    }
    public List<SearchHistory> getLastArtistsByText(String word){

        return searchHistoryRepository.findAllBySearchedWord(word);
    }
}
