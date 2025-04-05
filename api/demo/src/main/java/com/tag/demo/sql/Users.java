package com.tag.demo.sql;

import com.tag.demo.data.UserDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Getter
    String email;

    @Getter
    String password;

    @Getter
    String nameFirst;

    @Getter
    String nameLast;

    public UserDto toDto() {
        return UserDto.builder()
                .email(email)
                .password(password)
                .nameFirst(nameFirst)
                .nameLast(nameLast)
                .build();
    }
}