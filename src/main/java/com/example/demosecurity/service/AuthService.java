package com.example.demosecurity.service;

import com.example.demosecurity.dto.SignupRequest;
import com.example.demosecurity.dto.UserDTO;

public interface AuthService {

    UserDTO createUser(SignupRequest signupRequest);
}
