package com.hotel.config;

import java.security.Key;
import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    private static final Key SECRET_KEY = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);
    private final int EXPIRATION_TIME = 1000*60*60*3;

    public String generateToken(String email){
        return Jwts.builder()
        .setSubject(email)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
        .signWith(SECRET_KEY)
        .compact();
    }

    public String extractEmail(String token){
        return Jwts.parserBuilder()
        .setSigningKey(SECRET_KEY)
        .build()
        .parseClaimsJwt(token)
        .getBody()
        .getSubject();
    }

    private Date extractExpriration(String token){
        return Jwts.parserBuilder()
        .setSigningKey(SECRET_KEY)
        .build()
        .parseClaimsJws(token)
        .getBody()
        .getExpiration();
    }

    private boolean isTokenExpired(String token){
        return extractExpriration(token).before(new Date());
    }

    public boolean isValidToken(String token, UserDetails userDetails){
        String email = extractEmail(token);
        System.out.println(userDetails.getUsername());
        return (email.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}