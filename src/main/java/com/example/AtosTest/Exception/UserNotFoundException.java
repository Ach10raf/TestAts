package com.example.AtosTest.Exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("user non trouvé ");
    }
}