package com.spring_recipe.demo.service;

import io.jsonwebtoken.Claims;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import com.spring_recipe.demo.domain.JwtAuthentication;
import com.spring_recipe.demo.domain.JwtRequest;
import com.spring_recipe.demo.domain.JwtResponse;
import com.spring_recipe.demo.domain.entity.ApplicationUser;
import com.spring_recipe.demo.domain.exceptions.AuthException;
import com.spring_recipe.demo.repository.ApplicationUserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
@RequiredArgsConstructor
public class AuthService { private final ApplicationUserRepository userService;
    private final Map<String, String> refreshStorage = new HashMap<>();
    private final JwtProvider jwtProvider;

    public JwtResponse Email(@NonNull JwtRequest authRequest) {
        final ApplicationUser user = userService.findByEmail(authRequest.getEmail())
                .orElseThrow(() -> new AuthException("Пользователь не найден"));
        if (user.getPassword().equals(authRequest.getPassword())) {
            final String accessToken = jwtProvider.generateAccessToken(user);
            final String refreshToken = jwtProvider.generateRefreshToken(user);
            refreshStorage.put(user.getEmail(), refreshToken);
            return new JwtResponse(accessToken, refreshToken);
        } else {
            throw new AuthException("Неправильный пароль");
        }
    }

    public JwtResponse getAccessToken(@NonNull String refreshToken) {
        if (jwtProvider.validateRefreshToken(refreshToken)) {
            final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            final String Email = claims.getSubject();
            final String saveRefreshToken = refreshStorage.get(Email);
            if (saveRefreshToken != null && saveRefreshToken.equals(refreshToken)) {
                final ApplicationUser user = userService.findByEmail(Email)
                        .orElseThrow(() -> new AuthException("Пользователь не найден"));
                final String accessToken = jwtProvider.generateAccessToken(user);
                return new JwtResponse(accessToken, null);
            }
        }
        return new JwtResponse(null, null);
    }

    public JwtResponse refresh(@NonNull String refreshToken) {
        if (jwtProvider.validateRefreshToken(refreshToken)) {
            final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            final String Email = claims.getSubject();
            final String saveRefreshToken = refreshStorage.get(Email);
            if (saveRefreshToken != null && saveRefreshToken.equals(refreshToken)) {
                final ApplicationUser user = userService.findByEmail(Email)
                        .orElseThrow(() -> new AuthException("Пользователь не найден"));
                final String accessToken = jwtProvider.generateAccessToken(user);
                final String newRefreshToken = jwtProvider.generateRefreshToken(user);
                refreshStorage.put(user.getEmail(), newRefreshToken);
                return new JwtResponse(accessToken, newRefreshToken);
            }
        }
        throw new AuthException("Невалидный JWT токен");
    }

    public JwtAuthentication getAuthInfo() {
        return (JwtAuthentication) SecurityContextHolder.getContext().getAuthentication();
    }

}
