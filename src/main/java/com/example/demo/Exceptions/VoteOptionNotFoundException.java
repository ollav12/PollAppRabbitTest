package com.example.demo.Exceptions;

public class VoteOptionNotFoundException extends RuntimeException {
    public VoteOptionNotFoundException(String message) {
        super(message);
    }
}
