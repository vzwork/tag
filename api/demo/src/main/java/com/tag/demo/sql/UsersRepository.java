package com.tag.demo.sql;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);

    Users findByNameFirst(String nameFirst);

    Users findByNameLast(String nameLast);

    Users findByPassword(String password);

    // @Transactional
    // @Modifying
    // @Query("UPDATE Users u SET u.nameFirst = :nameFirst WHERE u.email = :email")
    // void updateUserNameFirst(@Param("email") String email, @Param("nameFirst")
    // String nameFirst);

    // @Transactional
    // @Modifying
    // @Query("UPDATE Users u SET u.nameLast = :nameLast WHERE u.email = :email")
    // void updateUserNameLast(@Param("email") String email, @Param("nameLast")
    // String nameLast);

    Optional findById(Long id);

}
