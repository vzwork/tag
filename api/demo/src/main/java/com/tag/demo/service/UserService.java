package com.tag.demo.service;

import java.util.List;

import com.tag.demo.data.UserDto;

public interface UserService {

    void createUser(UserDto userDto);

    List<UserDto> getUsers();

};