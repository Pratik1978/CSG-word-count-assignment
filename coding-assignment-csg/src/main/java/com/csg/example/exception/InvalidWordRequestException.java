package com.csg.example.exception;

public class InvalidWordRequestException extends RuntimeException {
    public InvalidWordRequestException(String message) {
        super(message);
    }

}
