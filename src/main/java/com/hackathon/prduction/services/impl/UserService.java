package com.hackathon.prduction.services.impl;

import com.hackathon.prduction.domain.dto.security.CreateUserRequestDTO;
import com.hackathon.prduction.domain.entity.User;

import com.hackathon.prduction.exceptions.user.UserAlreadyExistsException;

import com.hackathon.prduction.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements com.hackathon.prduction.services.UserService {
    private final UserRepository userRepository;

}
