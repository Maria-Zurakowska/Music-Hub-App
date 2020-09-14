package com.musichub.musichubapp.repository;

import com.musichub.musichubapp.entities.ArtistGrade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArtistGradeRepository extends CrudRepository<ArtistGrade, Integer> {

    @Override
    List<ArtistGrade> findAll();
    @Override
    Optional<ArtistGrade> findById(Integer id);
    @Override
    ArtistGrade save(ArtistGrade artistGrade);
    @Override
    void deleteById(Integer id);

    List<ArtistGrade> findFirstById(int id);
}
