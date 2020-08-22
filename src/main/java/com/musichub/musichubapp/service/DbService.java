package com.musichub.musichubapp.service;

import com.musichub.musichubapp.entities.User;
import com.musichub.musichubapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class DbService {

    private static final Logger LOGGER = Logger.getLogger(DbService.class.getName());

    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers(){

        return repository.findAll();
    }
    public Optional<User> getUser(Integer id){

        return repository.findById(id);
    }
    public User saveUser(final User user){

        if(user ==null){
            LOGGER.log(Level.SEVERE, "User is null!");
        }
        return repository.save(user);
    }
    public void deleteUser(Integer id){

        repository.deleteById(id);
    }
}
