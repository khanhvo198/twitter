package com.mystic.twitter.controllers;


import com.mystic.twitter.dtos.UserDTO;
import com.mystic.twitter.dtos.request.AuthenticationRequest;
import com.mystic.twitter.dtos.response.AuthenticationResponse;
import com.mystic.twitter.models.User;
import com.mystic.twitter.security.JwtService;
import com.mystic.twitter.security.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final JwtService jwtService;
    private final UserDetailService userService;
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        String token = jwtService.generateToken(request.getEmail(), "USER");

        User user = (User) userService.loadUserByUsername(request.getEmail());

        UserDTO userDTO = new UserDTO(
                user.getEmail(),
                user.getFirstName(),
                user.getLastName()
        );

        return ResponseEntity.ok(
                AuthenticationResponse.builder()
                        .token(token)
                        .user(userDTO)
                        .build()
        );
    }
}
