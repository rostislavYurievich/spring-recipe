package com.spring_recipe.demo.domain.dto;

import java.time.LocalDateTime;

import com.spring_recipe.demo.domain.entity.ApplicationUserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateAppUserRequest {
    private String name;
    private String email;
    private String password;
    private ApplicationUserRole role;
}