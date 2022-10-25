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
  private final TweetRepository tweetRepository;

  @Override
  public List<Tweet> findAllTweet() {
    return tweetRepository.findAll();
  }

  @Override
  public Tweet createTweet(String text) {
    Tweet tweet = new Tweet();
    tweet.setText(text);
    return tweetRepository.save(tweet);
  }

}
