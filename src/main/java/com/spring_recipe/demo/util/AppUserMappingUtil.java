package com.spring_recipe.demo.util;

import com.spring_recipe.demo.domain.dto.AppUserDto;
import com.spring_recipe.demo.domain.dto.CreateAppUserRequest;
import com.spring_recipe.demo.domain.entity.ApplicationUser;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

@UtilityClass
public class AppUserMappingUtil {

    public static AppUserDto mapToAppUserDto(ApplicationUser user) {
        return AppUserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .password(user.getPassword())
                .role(user.getRole().toString())
                .requestTime(LocalDateTime.now())
                .build();
    }

    public static ApplicationUser mapToAppUserFromRequest(CreateAppUserRequest user) {
        return ApplicationUser.builder()
                .email(user.getEmail())
                .name(user.getName())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }
}