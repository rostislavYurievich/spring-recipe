package com.spring_recipe.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors.toSet;

    @Getter
    @Setter
    public class JwtAuthentication implements Authentication {

        private boolean authenticated;
        private String Name;
        private String Email;
        private Set<Role> roles;

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() { return roles; }

        @Override
        public Object getCredentials() { return null; }

        @Override
        public Object getDetails() { return null; }

        @Override
        public Object getPrincipal() { return Name; }

        @Override
        public boolean isAuthenticated() { return authenticated; }

        @Override
        public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
            this.authenticated = isAuthenticated;
        }

        @Override
        public String getEmail() { return Email; }

    }

