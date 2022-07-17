package com.mystic.twitter.controllers;


import com.mystic.twitter.dtos.request.AuthenticationRequest;
import com.mystic.twitter.dtos.response.AuthenticationResponse;
import com.mystic.twitter.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    JwtService jwtService;
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        String token = jwtService.createToken(request.getEmail(), "USER");

        return ResponseEntity.ok(
                AuthenticationResponse.builder()
                        .token(token)
                        .build()
        );
    }
}
