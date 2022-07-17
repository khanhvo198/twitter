package com.mystic.twitter.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@RequiredArgsConstructor
public class JwtService {

    private static final String authenticationHeader = "Authentication";

    private final JwtEncoder jwtEncoder;

    public String createToken(String email, String role) {
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .expiresAt(Instant.now().plusSeconds(36000L))
                .subject(email)
                .claim("role", role)
                .claim("test","test")
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }


    public boolean validateToken() {
        return false;
    }

    public String resolveToken(HttpServletRequest request) {
        return request.getHeader(authenticationHeader);
    }

}
