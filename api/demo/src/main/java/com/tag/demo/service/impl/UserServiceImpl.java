package com.tag.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tag.demo.data.UserDto;
import com.tag.demo.service.UserService;
import com.tag.demo.sql.Users;
import com.tag.demo.sql.UsersRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UsersRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        Users user = Users.builder().email(userDto.getEmail())
                .nameFirst(userDto.getNameFirst())
                .nameLast(userDto.getNameLast())
                .password(userDto.getPassword()).build();

        userRepository.save(user);

        return user.toDto();
    }

    @Override
    public UserDto signIn(UserDto userIn) {
        Users user = userRepository.findByEmail(userIn.getEmail());
        if (user == null) {
            return null;
        }
        if (!user.getPassword().equals(userIn.getPassword())) {
            return null;
        }

        return UserDto.builder().email(user.getEmail())
                .nameFirst(user.getNameFirst())
                .nameLast(user.getNameLast())
                .password(user.getPassword()).build();
    }

    @Override
    public List<UserDto> getUsers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsers'");
    }

    @Transactional
    @Override
    public UserDto updateUser(UserDto userIn) {
        // userRepository.updateUserNameFirst(userIn.getEmail(), userIn.getNameFirst());
        // userRepository.updateUserNameLast(userIn.getEmail(), userIn.getNameLast());

        updateUserNameFirst(userIn);
        updateUserNameLast(userIn);

        Users user = userRepository.findByEmail(userIn.getEmail());

        return user.toDto();
    }

    // Even more vulnerable approach using direct SQL concatenation
    @Transactional
    void updateUserNameFirst(UserDto userIn) {
        // EXTREMELY VULNERABLE - Direct string concatenation
        String sql = "UPDATE users SET name_first = '" + userIn.getNameFirst() +
                "' WHERE id IN (SELECT id FROM users WHERE email = '" + userIn.getEmail() + "')";

        // Execute the raw SQL query
        entityManager.createNativeQuery(sql).executeUpdate();
    }

    // Even more vulnerable approach using direct SQL concatenation
    @Transactional
    void updateUserNameLast(UserDto userIn) {
        // EXTREMELY VULNERABLE - Direct string concatenation
        String sql = "UPDATE users SET name_last = '" + userIn.getNameLast() +
                "' WHERE id IN (SELECT id FROM users WHERE email = '" + userIn.getEmail() + "')";

        // Execute the raw SQL query
        entityManager.createNativeQuery(sql).executeUpdate();
    }

}
