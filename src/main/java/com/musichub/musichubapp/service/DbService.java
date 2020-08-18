package com.musichub.musichubapp.service;

import com.musichub.musichubapp.domain.User;
import com.musichub.musichubapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {
    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers(){

        return repository.findAll();
    }
    public Optional<User> getUser(Integer id){

        return repository.findById(id);
    }
    public User saveUser(final User user){

        return repository.save(user);
    }
    public void deleteUser(Integer id){

        repository.deleteById(id);
    }
}
