package com.example.demosecurity.service.impl;

import com.example.demosecurity.dto.SignupRequest;
import com.example.demosecurity.dto.UserDTO;
import com.example.demosecurity.entity.User;
import com.example.demosecurity.repository.UserRepository;
import com.example.demosecurity.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(SignupRequest signupRequest) {
        User user = new User();
        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(signupRequest.getPassword());
        User userCreate = userRepository.save(user);
        UserDTO userDTO = new UserDTO();
        userDTO.setName(userCreate.getName());
        userDTO.setEmail(userCreate.getEmail());
        userDTO.setPassword(userCreate.getPassword());
        return userDTO;
    }
}
