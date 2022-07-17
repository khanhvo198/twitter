package com.mystic.twitter.dtos;


import lombok.Data;

@Data
public class UserDTO {
    private final String email;
    private final String firstName;
    private final String lastName;
}
