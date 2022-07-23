package com.mystic.twitter.dtos.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class RegistrationResponse {
  private String status;
}
