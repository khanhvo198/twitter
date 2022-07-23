package com.mystic.twitter.security;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mystic.twitter.exceptions.ApiRequestException;
import com.mystic.twitter.repository.UserRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository
                        .findUserByEmail(email)
                        .orElseThrow(() -> new ApiRequestException("User " + email + "not found", HttpStatus.NOT_FOUND));

    }
}
