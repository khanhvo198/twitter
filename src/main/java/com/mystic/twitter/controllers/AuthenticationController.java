package com.mystic.twitter.controllers;


import java.time.LocalDateTime;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mystic.twitter.dtos.request.AuthenticationRequest;
import com.mystic.twitter.dtos.request.RegistrationRequest;
import com.mystic.twitter.dtos.response.ApiResponse;
import com.mystic.twitter.security.JwtService;
import com.mystic.twitter.security.UserDetailService;
import com.mystic.twitter.services.implementations.AuthenticationService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final JwtService jwtService;
    private final UserDetailService userService;
    private final AuthenticationService authenticationService;
    private final ModelMapper modelMapper;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest request) {
      String email = request.getEmail();
      String password = request.getPassword();

      Map<String, Object> data = authenticationService.login(email, password);
      

      return ResponseEntity.ok(
              ApiResponse.builder()
                      .timestamp(LocalDateTime.now())
                      .statusCode(HttpStatus.OK.value())
                      .status(HttpStatus.OK)
                      .data(data)
                      .message("Login successfully")
                      .build()
      );
    }

    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody RegistrationRequest request) {

        String status = authenticationService.registration(request.getEmail(), request.getPassword(), request.getFirstName(), request.getLastName());

        return ResponseEntity.ok(
                ApiResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .message(status)
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }



}
