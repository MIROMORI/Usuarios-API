package com.miromori.produtosapi.exceptions.custom_exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserListIsEmptyException extends RuntimeException {
    public UserListIsEmptyException(String message) {
        super(message);
    }
}
