package com.mystic.twitter.services.implementations;

import com.mystic.twitter.dtos.request.TweetRequest;
import com.mystic.twitter.models.Tweet;
import com.mystic.twitter.repository.TweetRepository;
import com.mystic.twitter.services.ITweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TweetService implements ITweetService {
    TweetRepository tweetRepository;

    @Override
    public List<Tweet> findAllTweet() {
        return tweetRepository.findAll();
    }

    public Tweet createdTweet(Tweet tweet) {
        return tweetRepository.save(tweet);
    }


}
