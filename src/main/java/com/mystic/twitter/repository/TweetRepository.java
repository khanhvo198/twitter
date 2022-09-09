package com.mystic.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mystic.twitter.models.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {

}
