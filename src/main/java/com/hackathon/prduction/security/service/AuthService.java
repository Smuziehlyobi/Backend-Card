package com.hackathon.prduction.security.service;

import com.hackathon.prduction.domain.dto.security.AuthDTO;
import com.hackathon.prduction.domain.dto.security.CreateUserRequestDTO;
import com.hackathon.prduction.domain.dto.security.JwtResponse;
import com.hackathon.prduction.domain.dto.security.JwtWithCardResponseDTO;
import com.hackathon.prduction.domain.entity.Role;
import com.hackathon.prduction.domain.entity.User;
import com.hackathon.prduction.exceptions.AuthException;
import com.hackathon.prduction.security.jwt.JwtCore;
import com.hackathon.prduction.security.service.impl.UserServiceImpl;
import com.hackathon.prduction.services.CardService;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.Objects;


@Component
@RequiredArgsConstructor
public class AuthService {

    private final JwtCore jwtCore;
    private final AuthenticationManager authenticationManager;
    private final UserServiceImpl userService;

    public JwtWithCardResponseDTO registration(CreateUserRequestDTO createUserRequestDTO) {
        if (!Objects.equals(createUserRequestDTO.getPassword(), createUserRequestDTO.getRepeatPassword())) {
            throw AuthException.CODE.INVALID_REPEAT_PASSWORD.get();
        }

        if( userService.findByEmail(createUserRequestDTO.getEmail()).isPresent() ){
            throw AuthException.CODE.EMAIL_IN_USE.get();
        }

        User user = userService.save(createUserRequestDTO);

        String accessToken = jwtCore.generateAccessToken(user);
        String refreshToken = jwtCore.generateRefreshToken(user);

        return new JwtWithCardResponseDTO(accessToken, refreshToken, user.getCard().getValue(), user.getCard().getBalance(),
                user.getFirstName(), user.getLastName(), user.getPatronymic());
    }

    public JwtResponse login(AuthDTO authDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authDto.getUsername(), authDto.getPassword()));
        } catch (BadCredentialsException e) {
            throw AuthException.CODE.NO_SUCH_USERNAME_OR_PWD.get();
        }

        final User user = userService
                .findByEmail(authDto.getUsername())
                .orElseThrow(AuthException.CODE.NO_SUCH_USERNAME_OR_PWD::get);
        final String accessToken = jwtCore.generateAccessToken(user);
        final String refreshToken = jwtCore.generateRefreshToken(user);
        return new JwtResponse(accessToken, refreshToken);
    }

    public JwtResponse getAccessToken(String refreshToken) {
        return generateAccessTokenOrRefresh(refreshToken, "getAccessToken");
    }

    public JwtResponse refresh(String refreshToken) {
        return generateAccessTokenOrRefresh(refreshToken, "refresh");
    }

    private JwtResponse generateAccessTokenOrRefresh(String refreshToken, String action) {
        if (jwtCore.validateRefreshToken(refreshToken)) {
            final Claims claims = jwtCore.extractRefreshClaims(refreshToken);
            final String username = claims.getSubject();
            final String roleName = (String) claims.get("role");
            Integer idInt = (Integer) claims.get("user_id");
            final Long id = Long.valueOf(idInt);
            Role role = new Role();
            role.setName(roleName);
            User userForJwt = new User();
            userForJwt.setEmail(username);
            userForJwt.setRole(role);
            userForJwt.setId(Long.valueOf(id));
            final String accessToken = jwtCore.generateAccessToken(userForJwt);
            if (action.equals("refresh")) {
                final String newRefreshToken = jwtCore.generateRefreshToken(userForJwt);
                return new JwtResponse(accessToken, newRefreshToken);
            } else {
                return new JwtResponse(accessToken, null);
            }
        }
        return new JwtResponse(null, null);
    }
}
