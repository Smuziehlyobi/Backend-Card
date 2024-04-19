package com.hackathon.prduction.services;

import com.hackathon.prduction.domain.models.Role;
import com.hackathon.prduction.domain.models.User;
import com.hackathon.prduction.exceptions.InvalidRegistrationException;
import com.hackathon.prduction.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public User save(User user) {
        return repository.save(user);
    }


    public User create(User user) {
        if (repository.existsByUsername(user.getUsername())) {
            throw new InvalidRegistrationException("User with the same name already exists");
        }

        if (repository.existsByEmail(user.getEmail())) {
            throw new InvalidRegistrationException("user with the same email already exists");
        }

        return save(user);
    }

    public User getByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User is not found"));

    }

    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }

    public User getCurrentUser() {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUsername(username);
    }



}
