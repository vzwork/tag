package com.tag.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.tag.demo.data.GenericResponse;
import com.tag.demo.data.UserDto;
import com.tag.demo.service.UserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
        return ResponseEntity.ok(GenericResponse.success(
                userService.createUser(user), "ok"));
    }

    @PostMapping("signIn")
    public ResponseEntity<GenericResponse<UserDto>> signIn(@RequestBody UserDto userIn) {
        UserDto user = userService.signIn(userIn);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password");
        }
        return ResponseEntity.ok(GenericResponse.success(user, "ok"));
    }

    @PutMapping("updateUser")
    public ResponseEntity<GenericResponse<UserDto>> putMethodName(@RequestBody UserDto userIn) {
        // TODO: process PUT request

        UserDto user = userService.updateUser(userIn);

        return ResponseEntity.ok(GenericResponse.success(user, "ok"));
    }

}
