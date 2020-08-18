package com.musichub.musichubapp.service;

// klasa służacą do pobierania, usuwania, modyfikowania itp. Artist w bazie danych (stworzę opcję dodawania artysty
//do ulubionych i tym samym stworzę tabelę z ulubionymi artystami, więc musiałam też stworzyć osobną klasę Artist).

import com.musichub.musichubapp.domain.Artist;
import com.musichub.musichubapp.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbArtistService {

// tworzę obiekt ArtistRepository po to, aby zaciągnąć metody z tej klasy.
    @Autowired
    ArtistRepository artistRepository;

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
}
