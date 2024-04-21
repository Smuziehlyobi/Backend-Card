package com.hackathon.prduction.services.impl;


import com.hackathon.prduction.domain.dto.user.UserResponseInfoDTO;
import com.hackathon.prduction.domain.mapper.user.UserResponseInfoMapper;
import com.hackathon.prduction.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements com.hackathon.prduction.services.UserService {
    private final UserRepository userRepository;

    private final UserResponseInfoMapper userResponseInfoMapper;

    @Transactional
    public UserResponseInfoDTO getUser () {
        UsernamePasswordAuthenticationToken details = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) details.getPrincipal();
        String username = userDetails.getUsername();
        return userResponseInfoMapper.toDto(userRepository.findByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException("Такого вообще быть не может")));
    }
}
