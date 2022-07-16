package com.mystic.twitter.repository;

import com.mystic.twitter.models.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITweetRepository extends JpaRepository<Tweet, Long> {

}
