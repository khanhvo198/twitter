package com.mystic.twitter.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ApiRequestException extends RuntimeException {

  private final HttpStatus status;

  public ApiRequestException(String message, HttpStatus httpStatus) {
    super(message);
    this.status = httpStatus;
  }

}
