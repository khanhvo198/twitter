package com.mystic.twitter.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mystic.twitter.models.Tweet;
import com.mystic.twitter.repository.TweetRepository;
import com.mystic.twitter.services.ITweetService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TweetService implements ITweetService {
    TweetRepository tweetRepository;

    @Override
    public List<Tweet> findAllTweet() {
        return tweetRepository.findAll();
    }

    public Tweet createTweet(Tweet tweet) {
        return tweetRepository.save(tweet);
    }


}
