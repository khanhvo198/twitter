package com.mystic.twitter.dtos.response;

import com.mystic.twitter.dtos.UserDTO;
import lombok.Data;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
public class AuthenticationResponse {
    private String token;
    private UserDTO user;
}
