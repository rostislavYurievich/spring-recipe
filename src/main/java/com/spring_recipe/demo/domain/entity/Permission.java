package com.spring_recipe.demo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@AllArgsConstructor
public enum Permission implements GrantedAuthority {
    READ("read"),
    MODIFY("modification"),
    ADMIN("admin");

    private final String permission;
    public String getAuthority() {
        return permission;
}
}
