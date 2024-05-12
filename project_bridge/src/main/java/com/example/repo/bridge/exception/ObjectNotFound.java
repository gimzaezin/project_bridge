package com.example.repo.bridge.exception;

import org.springframework.http.HttpStatus;

public class ObjectNotFound extends ApiException {
    public ObjectNotFound(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }

}
