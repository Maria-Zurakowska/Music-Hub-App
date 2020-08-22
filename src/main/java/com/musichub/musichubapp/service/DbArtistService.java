package com.musichub.musichubapp.service;

import com.musichub.musichubapp.entities.Artist;
import com.musichub.musichubapp.entities.ArtistGrade;
import com.musichub.musichubapp.repository.ArtistGradeRepository;
import com.musichub.musichubapp.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbArtistService {

    @Autowired
    ArtistRepository artistRepository;

    @Autowired
    ArtistGradeRepository artistGradeRepository;

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
    public void deleteArtistGrade (Integer id){
        artistGradeRepository.deleteById(id);
    }

}
