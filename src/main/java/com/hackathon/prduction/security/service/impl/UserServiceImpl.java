package com.hackathon.prduction.security.service.impl;

import com.hackathon.prduction.domain.dto.security.CreateUserRequestDTO;
import com.hackathon.prduction.domain.entity.Role;
import com.hackathon.prduction.domain.entity.User;
import com.hackathon.prduction.domain.mapper.CreateUserRequestDTOMapper;
import com.hackathon.prduction.exceptions.role.RoleNotFoundException;
import com.hackathon.prduction.repository.RoleRepository;
import com.hackathon.prduction.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor

@Service
public class UserServiceImpl {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CreateUserRequestDTOMapper createUserRequestDTOMapper;
    private final PasswordEncoder encoder;



    @Transactional
    public User save(CreateUserRequestDTO userResponseDTO) {
        User user = createUserRequestDTOMapper.toEntity(userResponseDTO);
        Role role = roleRepository.findByName("USER").orElse(null);
        if(role == null){
            throw new RoleNotFoundException("Role not found");
        }
        user.setRole(role);
        user.setPassword(encoder.encode(userResponseDTO.getPassword()));
        userRepository.save(user);
        return user;
    }

    public Optional<User> findByEmail(String email){
        Optional<User> user = userRepository.findByEmail(email);
        return user;
    }
}
