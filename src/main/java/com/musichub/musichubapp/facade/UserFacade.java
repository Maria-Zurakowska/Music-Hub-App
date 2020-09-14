package com.musichub.musichubapp.facade;


import com.musichub.musichubapp.domain.Dto.UserDto;

import com.musichub.musichubapp.mapper.UserMapper;

import com.musichub.musichubapp.service.DbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFacade {

    @Autowired
    private DbUserService dbUserService;

    @Autowired
    private UserMapper userMapper;

    public List<UserDto> getUsers(){
        return userMapper.mapToUserDtoList(dbUserService.getAllUsers());}

}
