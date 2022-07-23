package com.mystic.twitter.security;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class JwtService {
    private final UserDetailService userService;

    private static final String authenticationHeader = "Authentication";
    private final String secretKey = "this-is-secret-key";

    public String generateToken(String email, String role) {

        Claims claims = Jwts.claims().setSubject(email);
        claims.put("role", role);
        Date now = new Date();

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() +     3600*1000))
                .signWith(SignatureAlgorithm.HS256,secretKey)
                .compact();

    }


    public boolean isValidToken(String token) {
        return true;
    }

    public String resolveToken(HttpServletRequest request) {
        return request.getHeader(authenticationHeader);
    }

    public Authentication getAuthentication(String token) {
        UserDetails user = userService.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(user,"",user.getAuthorities());
    }

    public String getUsername(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

}
