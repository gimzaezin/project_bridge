package com.example.repo.bridge.exception;

import org.springframework.http.HttpStatus;

public class MissingValueException extends ApiException {
    public MissingValueException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
