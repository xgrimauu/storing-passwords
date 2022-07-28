package com.xgrimau.storingpasswords.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserEntityNotFoundException extends RuntimeException {

    public UserEntityNotFoundException(String username) {
        super(String.format("Username %s not found", username));
    }
}
