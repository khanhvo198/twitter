package com.mystic.twitter.services;

import java.util.List;

import com.mystic.twitter.dtos.request.TweetRequest;
import com.mystic.twitter.models.Tweet;

public interface ITweetService {

  List<Tweet> findAllTweet();

  Tweet createTweet(TweetRequest text);
}
