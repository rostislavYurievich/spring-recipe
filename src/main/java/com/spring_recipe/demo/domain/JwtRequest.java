package com.spring_recipe.demo.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JwtRequest {
    private String email;
    private String password;
}
