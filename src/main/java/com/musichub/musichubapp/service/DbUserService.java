package com.musichub.musichubapp.service;

import com.musichub.musichubapp.entities.SearchHistory;
import com.musichub.musichubapp.entities.User;
import com.musichub.musichubapp.repository.SearchHistoryRepository;
import com.musichub.musichubapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class DbUserService {

    private static final Logger LOGGER = Logger.getLogger(DbUserService.class.getName());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SearchHistoryRepository searchHistoryRepository;


    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    public Optional<User> getUser(Integer id) {

        return userRepository.findById(id);
    }

    public User saveUser(final User user) {

        if (user == null) {
            LOGGER.log(Level.SEVERE, "User is null!");
        }
        return userRepository.save(user);
    }

    public void deleteUser(Integer id) {

        userRepository.deleteById(id);
    }

    public List<SearchHistory> getLastArtistsByWhenSearched(LocalDate date) {
        return searchHistoryRepository.findAllByWhenSearched(date);
    }

    public void updatePassword(String oldPassword, String newPassword, Integer userId) {
        userRepository.findById(userId).ifPresent(u -> {
            String currentPassword = u.getPassword();
            if (currentPassword.equals(oldPassword)) {
                u.setPassword(newPassword);
                userRepository.save(u);
            }
        });
    }

    public void updateFirstName(String password, Integer userId, String firstName) {
        userRepository.findById(userId).ifPresent(u -> {
            String currentPassword = u.getPassword();
            if (currentPassword.equals(password)) {
                u.setFirstName(firstName);
                userRepository.save(u);
            }
        });
    }

    public void updateLastName(String password, Integer userId, String lastName) {
        userRepository.findById(userId).ifPresent(u -> {
            String currentPassword = u.getPassword();
            if (currentPassword.equals(password)) {
                u.setFirstName(lastName);
                userRepository.save(u);
            }
        });
    }

    public void updateCity(String password, Integer userId, String city) {
        userRepository.findById(userId).ifPresent(u -> {
            String currentPassword = u.getPassword();
            if (currentPassword.equals(password)) {
                u.setFirstName(city);
                userRepository.save(u);
            }
        });
    }
}
