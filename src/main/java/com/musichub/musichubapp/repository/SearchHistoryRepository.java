package com.musichub.musichubapp.repository;


import com.musichub.musichubapp.entities.SearchHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface SearchHistoryRepository extends CrudRepository<SearchHistory, Integer> {

    @Override
    List<SearchHistory> findAll();
    @Override
    Optional<SearchHistory> findById(Integer id);
    @Override
    SearchHistory save(SearchHistory searchHistory);
    @Override
    void deleteById(Integer id);

    List<SearchHistory> findFirstById(int id);


    List<SearchHistory> findAllByWhenSearched(LocalDate date);

    List<SearchHistory> findAllBySearchedWord(String text);




}
