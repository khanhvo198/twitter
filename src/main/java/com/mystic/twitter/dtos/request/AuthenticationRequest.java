package com.mystic.twitter.dtos.request;

import lombok.Data;

@Data
public class AuthenticationRequest {
  private String email;
  private String password;

}
