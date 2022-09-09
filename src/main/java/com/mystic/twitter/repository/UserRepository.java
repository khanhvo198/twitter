package com.mystic.twitter.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mystic.twitter.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findUserByEmail(String email);

}
