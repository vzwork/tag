package com.tag.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.tag.demo.data.UserDto;
import com.tag.demo.service.UserService;
import com.tag.demo.sql.Users;
import com.tag.demo.sql.UsersRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository userRepository;

    @Override
    public void createUser(UserDto userDto) {

        Users user = Users.builder().email(userDto.getEmail())
                .nameFirst(userDto.getNameFirst())
                .nameLast(userDto.getNameLast())
                .password(userDto.getPassword()).build();

        userRepository.save(user);

        log.info("Creating user: {}", user);
    }

    @Override
    public List<UserDto> getUsers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsers'");
    }

}
