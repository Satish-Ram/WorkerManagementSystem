package com.example.demo.config;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	private final String SECRET="mySecretKeyForWorkerManagementProject";
	
	public String generateToken(String email) {
		return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(
                    new Date(
                        System.currentTimeMillis()
                        + 86400000))
                .signWith(
                    Keys.hmacShaKeyFor(
                        SECRET.getBytes()),
                    Jwts.SIG.HS256)
                .compact();
	}
	public String extractUsername(String token) {
		return Jwts.parser().verifyWith(Keys.hmacShaKeyFor(SECRET.getBytes())).build().parseSignedClaims(token).getPayload().getSubject();
	}
	
	public boolean validateToken(
	        String token,
	        String username) {

	    String extractedUsername =
	            extractUsername(token);

	    return extractedUsername
	            .equals(username);
	}
}
