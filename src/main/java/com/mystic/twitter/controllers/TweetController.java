package com.mystic.twitter.controllers;


import com.mystic.twitter.dtos.request.TweetRequest;
import com.mystic.twitter.dtos.response.TweetHeaderResponse;
import com.mystic.twitter.models.Tweet;
import com.mystic.twitter.services.implementations.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tweets")
public class TweetController {

    TweetService tweetService;
    @GetMapping
    public ResponseEntity<TweetHeaderResponse> index () {
        return ResponseEntity.ok(
                TweetHeaderResponse.builder()
                        .timestamp(now())
                        .message("Get all tweet success")
                        .status(OK)
                        .statusCode(OK.value())
                        .data(of("tweets",tweetService.findAllTweet()))
                        .build()
        );
    }


    @PostMapping
    public ResponseEntity<TweetHeaderResponse> create(@RequestBody Tweet tweet ) {
        return ResponseEntity.ok(
                TweetHeaderResponse.builder()
                        .timestamp(now())
                        .message("Created Successfully")
                        .data(of("tweet", tweetService.createdTweet(tweet)))
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }





}
