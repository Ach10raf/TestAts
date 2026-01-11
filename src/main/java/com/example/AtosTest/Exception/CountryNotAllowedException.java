package com.example.AtosTest.Exception;

public class CountryNotAllowedException extends BusinessException {
    public CountryNotAllowedException() {
        super("que les users français sont autorisés");
    }
}
