package com.mystic.twitter.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mystic.twitter.dtos.request.TweetRequest;
import com.mystic.twitter.mapper.TemplateMapper;
import com.mystic.twitter.models.Tweet;
import com.mystic.twitter.repository.TweetRepository;
import com.mystic.twitter.services.ITweetService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TweetService implements ITweetService {
  private final TweetRepository tweetRepository;

  private final TemplateMapper templateMapper;

  @Override
  public List<Tweet> findAllTweet() {
    return tweetRepository.findAll();
  }

  @Override
  public Tweet createTweet(TweetRequest tweetRequest) {
    Tweet tweet = templateMapper.convertToEntity(tweetRequest, Tweet.class);
    return tweetRepository.save(tweet);
  }

}
