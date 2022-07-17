package com.mystic.twitter.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class ApiRequestException extends RuntimeException{

    private final HttpStatus status;

    public ApiRequestException(String message, HttpStatus httpStatus) {
        super(message);
        this.status = httpStatus;
    }


}
