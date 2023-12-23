package com.spring_recipe.demo.domain;

import com.spring_recipe.demo.domain.entity.ApplicationUserRole;
import com.spring_recipe.demo.domain.entity.Permission;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Set;


    @Getter
    @Setter
    public class JwtAuthentication implements Authentication {

        private boolean authenticated;
        private String Name;
        private String Email;
        private ApplicationUserRole role;

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() { return role.grantedAuthority(); }

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


        public String getEmail() { return Email; }

    }

