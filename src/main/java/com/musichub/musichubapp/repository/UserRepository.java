package com.musichub.musichubapp.repository;

import com.musichub.musichubapp.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    @Override
    List<User> findAll();
    @Override
    Optional<User> findById(Integer id);
    @Override
    User save(User user);
    @Override
    void deleteById(Integer id);
}
