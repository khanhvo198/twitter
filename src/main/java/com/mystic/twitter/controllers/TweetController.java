package com.mystic.twitter.controllers;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mystic.twitter.dtos.response.TweetHeaderResponse;
import com.mystic.twitter.models.Tweet;
import com.mystic.twitter.services.implementations.TweetService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tweets")
public class TweetController {

  TweetService tweetService;

  @GetMapping
  public ResponseEntity<TweetHeaderResponse> index() {
    return ResponseEntity.ok(
        TweetHeaderResponse.builder()
            .timestamp(now())
            .message("Get all tweet success")
            .status(OK)
            .statusCode(OK.value())
            .data(of("tweets", tweetService.findAllTweet()))
            .build());
  }

  @PostMapping
  public ResponseEntity<TweetHeaderResponse> create(@RequestBody Tweet tweet) {
    return ResponseEntity.ok(
        TweetHeaderResponse.builder()
            .timestamp(now())
            .message("Created Successfully")
            .data(of("tweet", tweetService.createTweet(tweet)))
            .status(CREATED)
            .statusCode(CREATED.value())
            .build());
  }

}
