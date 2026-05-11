
package com.gbm.security.jwt;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTSecurityManager {

	private String secretKey = "mySecretKey12345";

    // Generate Token
    
	public   String generateToken(String username) {
    	
    	System.out.println("GenToken username:"+username);
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
				.signWith(SignatureAlgorithm.HS512, secretKey)
				.compact();
	}

	// Extract Username
	public String extractUsername(String token) {
		return getClaims(token).getSubject();
	}

	// Validate Token
	public boolean validateToken(String token, String username) {
		String extractedUsername = extractUsername(token);
		return (extractedUsername.equals(username) && !isTokenExpired(token));
	}

	private boolean isTokenExpired(String token) {
		return getClaims(token).getExpiration().before(new Date());
	}

	private Claims getClaims(String token) {
		return Jwts.parser()
				.setSigningKey(secretKey)
				.parseClaimsJws(token)
				.getBody();
	}
}