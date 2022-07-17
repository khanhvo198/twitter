package com.mystic.twitter.security;

import com.mystic.twitter.exceptions.ApiRequestException;
import com.mystic.twitter.models.User;
import com.mystic.twitter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository
                        .findUserByEmail(email)
                        .orElseThrow(() -> new ApiRequestException("User " + email + "not found", HttpStatus.NOT_FOUND));

    }
}
