package com.hackathon.prduction.services.impl;

import com.hackathon.prduction.domain.entity.User;

import com.hackathon.prduction.exceptions.user.UserAlreadyExistsException;

import com.hackathon.prduction.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public User create(User user) {

        Optional<User> userFromDb = userRepository.findByEmail(user.getEmail());

        if(userFromDb.isPresent()){
            throw new UserAlreadyExistsException("");
        }
        return userRepository.save(user);

    }

}
