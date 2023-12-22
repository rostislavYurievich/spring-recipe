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

public class RecipeDtoOut  {
    private String name;
    private int userId;
    private String description;
    private String image;
    private String[] steps ;
    private LocalDateTime requestTime;
    private String metka;

}