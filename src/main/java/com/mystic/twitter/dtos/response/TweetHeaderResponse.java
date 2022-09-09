package com.mystic.twitter.dtos.response;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@JsonInclude(NON_NULL)
public class TweetHeaderResponse {
  private LocalDateTime timestamp;
  private int statusCode;
  private HttpStatus status;
  private String reason;
  private String message;
  private Map<?, ?> data;
}
