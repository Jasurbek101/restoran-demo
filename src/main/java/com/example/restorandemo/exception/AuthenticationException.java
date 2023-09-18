package com.example.restorandemo.exception;


public class AuthenticationException extends RuntimeException {
    public AuthenticationException() {
        super("Incorrect phone number or password");
    }
}

