package com.workintech.s18d2.exceptions;

public class FruitNotFoundException extends RuntimeException {
    public FruitNotFoundException(Long message) {
        super(String.valueOf(message));
    }
}
