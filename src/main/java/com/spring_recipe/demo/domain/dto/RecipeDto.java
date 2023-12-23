package com.spring_recipe.demo.domain.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class RecipeDto {
    private String name;
    private int userId;
    private UUID id;
    private String description;
    private String image;
    private UUID stepId;
    private LocalDateTime requestTime;
    private String metka;
}