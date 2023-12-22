package com.spring_recipe.demo.domain.dto;

import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUserDto {
    private int id;
    private String name;
    private String email;
    private String password;
    private String role;
    private LocalDateTime requestTime;
}