package com.musichub.musichubapp.repository;
import com.musichub.musichubapp.domain.Artist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Integer> {

    @Override
    List<Artist> findAll();
    @Override
    Optional<Artist> findById(Integer id);
    @Override
    Artist save(Artist user);
    @Override
    void deleteById(Integer id);
}
