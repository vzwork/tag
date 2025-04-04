package com.tag.demo.sql;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);

    Users findByNameFirst(String nameFirst);

    Users findByNameLast(String nameLast);

    Users findByPassword(String password);

    Optional findById(Long id);

}
