package com.mystic.twitter.dtos.request;

import lombok.Data;

@Data
public class RegistrationRequest {
  private String email;
  private String password;
  private String firstName;
  private String lastName;
}
