package com.tag.demo.service;

import java.util.List;

import com.tag.demo.data.UserDto;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto signIn(UserDto userIn);

    UserDto updateUser(UserDto userIn);

    List<UserDto> getUsers();

};