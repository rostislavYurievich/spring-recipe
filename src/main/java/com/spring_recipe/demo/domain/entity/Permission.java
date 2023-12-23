package com.spring_recipe.demo.domain.entity;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Permission{
    READ("read"),
    MODIFY("modification"),
    ADMIN("admin");

    private final String permission;
}