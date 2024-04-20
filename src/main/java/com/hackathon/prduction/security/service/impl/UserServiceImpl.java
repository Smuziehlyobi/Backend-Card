package com.hackathon.prduction.security.service.impl;

import com.hackathon.prduction.domain.dto.security.CreateUserRequestDTO;
import com.hackathon.prduction.domain.entity.User;
import com.hackathon.prduction.domain.mapper.CreateUserRequestDTOMapper;
import com.hackathon.prduction.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor

@Service
public class UserServiceImpl {
    private final UserRepository userRepository;
    private final CreateUserRequestDTOMapper createUserRequestDTOMapper;


    @Transactional
    public User save(CreateUserRequestDTO userResponseDTO) {
        User user = createUserRequestDTOMapper.toEntity(userResponseDTO);
        userRepository.save(user);
        return user;
    }

    public Optional<User> findByEmail(String email){
        Optional<User> user = userRepository.findByEmail(email);
        return user;
    }
}
