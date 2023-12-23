package com.spring_recipe.demo.domain.exceptions;

public class AuthException extends RuntimeException {

    public AuthException(String message) {
        super(message);
    }

}