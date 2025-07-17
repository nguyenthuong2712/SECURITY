package com.example.demosecurity.controller;

import com.example.demosecurity.dto.SignupRequest;
import com.example.demosecurity.dto.UserDTO;
import com.example.demosecurity.service.impl.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupUserController {

    @Autowired
    private AuthServiceImpl authService;

    @PostMapping("/sign-up")
    private ResponseEntity<?> createUser(@RequestBody SignupRequest signupRequest) {
        UserDTO createUser = authService.createUser(signupRequest);
        if (createUser == null) {
            return new ResponseEntity<>("User is not created, try again later", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createUser, HttpStatus.CREATED);
    }
}
