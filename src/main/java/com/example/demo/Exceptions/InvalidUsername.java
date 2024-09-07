package com.example.demo.Exceptions;

public class InvalidUsername extends RuntimeException {
    public InvalidUsername(String message) {
        super(message);
    }
}
