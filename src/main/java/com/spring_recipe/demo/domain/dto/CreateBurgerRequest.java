package com.spring_recipe.demo.domain.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateBurgerRequest {
    private String name;
    private int userId;
    private String kotleta;
    private String sauce;
    private String description;
    private String image;
    private String[] ingredients;


}
