package com.mystic.twitter.services;

import com.mystic.twitter.models.Tweet;

import java.util.List;

public interface ITweetService {

    List<Tweet> findAllTweet();

}
