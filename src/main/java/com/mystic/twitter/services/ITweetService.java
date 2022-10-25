package com.mystic.twitter.services;

import java.util.List;

import com.mystic.twitter.models.Tweet;

public interface ITweetService {

  List<Tweet> findAllTweet();

  Tweet createTweet(String text);
}
