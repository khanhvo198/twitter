package com.mystic.twitter.dtos.response;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.experimental.SuperBuilder;



@Data
@SuperBuilder
public class ApiResponse {
  private LocalDateTime timestamp;
  private int statusCode;
  private HttpStatus status;
  private String reason;
  private String message;
  private Map<?,?> data;
}
