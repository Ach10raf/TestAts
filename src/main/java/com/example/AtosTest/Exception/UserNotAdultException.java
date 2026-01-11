package com.example.AtosTest.Exception;

public class UserNotAdultException extends BusinessException {
    public UserNotAdultException() {
        super("user doit etre adulte");
    }
}
