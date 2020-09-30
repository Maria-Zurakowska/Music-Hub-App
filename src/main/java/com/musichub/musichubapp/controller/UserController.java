package com.musichub.musichubapp.controller;

import com.musichub.musichubapp.domain.Dto.UserDto;
import com.musichub.musichubapp.facade.UserFacade;
import com.musichub.musichubapp.mapper.SearchHistoryMapper;
import com.musichub.musichubapp.mapper.UserMapper;
import com.musichub.musichubapp.service.DbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    DbUserService dbUserService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserFacade userFacade;

    @Autowired
    SearchHistoryMapper searchHistoryMapper;


    @RequestMapping(method = RequestMethod.GET, value = "getUser")
    public UserDto getUser(@RequestParam Integer userId) throws UserNotFoundException {
        return userMapper.mapToUserDto(dbUserService.getUser(userId).orElseThrow(UserNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUsers")
    public List<UserDto> getUsers() {
        return userFacade.getUsers();

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteUser")
    public void deleteUser(@RequestParam Integer userId) {

        dbUserService.deleteUser(userId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateUser")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userMapper.mapToUserDto(dbUserService.saveUser(userMapper.mapToUser(userDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createUser", consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        dbUserService.saveUser(userMapper.mapToUser(userDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updatePassword")
    public void updatePassword(@RequestParam String oldPass, @RequestParam String newPass, @RequestParam Integer userId) {

        dbUserService.updatePassword(oldPass, newPass, userId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateFirstName")
    public void updateName(@RequestParam String password, @RequestParam Integer userId, @RequestParam String firstName) {
        dbUserService.updateFirstName(password, userId, firstName);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateLastName")
    public void updateLastName(@RequestParam String password, @RequestParam Integer userId, @RequestParam String lastName) {
        dbUserService.updateLastName(password, userId, lastName);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateCity")
    public void updateCity(@RequestParam String password, @RequestParam Integer userId, @RequestParam String city) {
        dbUserService.updateCity(password, userId, city);
    }
}
