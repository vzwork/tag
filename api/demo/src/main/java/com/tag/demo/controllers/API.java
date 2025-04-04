package com.tag.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.tag.demo.data.GenericResponse;
import com.tag.demo.data.UserDto;
import com.tag.demo.service.UserService;
import com.tag.demo.sql.Users;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

@RestController
@RequestMapping("/")
public class API {

    @Autowired
    private UserService userService;

    @GetMapping("helloWorld")
    public ResponseEntity<GenericResponse<String>> helloWorld(@RequestParam String param) {
        return ResponseEntity.ok(GenericResponse.success("Hello World, ", param));
    }

    @PostMapping("createUser")
    public ResponseEntity<GenericResponse<UserDto>> getMethodName(@RequestBody UserDto user) {
        userService.createUser(user);
        return ResponseEntity.ok(GenericResponse.success(null, "ok")

        );
    }

}
