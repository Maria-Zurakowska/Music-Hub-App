package com.musichub.musichubapp.mapper;
import com.musichub.musichubapp.domain.Dto.UserDto;
import com.musichub.musichubapp.entities.Artist;
import com.musichub.musichubapp.entities.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public List<UserDto> mapToUserDtoList(final List<User> userList) {
        return userList.stream()
                .map(a -> new UserDto(a.getId(), a.getFirstName(), a.getLastName(), a.getEmail(), a.getPassword(), a.getAge(), a.getGender(), a.getCity(), a.getCountry(), a.getLikedArtists(), a.getSearchHistoryList()))
                .collect(Collectors.toList());
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getAge(),
                user.getGender(),
                user.getCity(),
                user.getCountry(),
                user.getLikedArtists(),
                user.getSearchHistoryList());
    }

    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getAge(),
                userDto.getGender(),
                userDto.getCity(),
                userDto.getCountry(),
                userDto.getLikedArtists(),
                userDto.getSearchHistoryList());
    }
}
