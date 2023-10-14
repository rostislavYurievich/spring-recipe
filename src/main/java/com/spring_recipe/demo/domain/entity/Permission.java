package com.spring_recipe.demo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Permission {
    READ("read"),
    MODIFY("modify"),
    ADMIN("admin");

    private final String permission;
}