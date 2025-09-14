package com.gl.security;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {

    private final Key key;
    private final long expirationMs;

    public JWTService(
            @Value("${app.jwt.secret}") String secret,
            @Value("${app.jwt.expiration-ms}") long expirationMs) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.expirationMs = expirationMs;
    }

    // generate new token (username, expiration time)
    
    public String generateToken(String username, Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims) 
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
    //retrieve the claims/info from inside the token
    public <T> T extractClaim(String token, Function<Claims, T> resolver) {
        
				   Claims claims = Jwts.parserBuilder()
				    .setSigningKey(key)
				    .build()
				    .parseClaimsJws(token)
				    .getBody();
				    return resolver.apply(claims);
    }
    // extract username from token
    public String extractUsername(String token) {
    	return extractClaim(token, Claims::getSubject);
    
    }
    // check whether token is expired or not
	   public boolean isTokenExpired(String token) {
		  Date expDate = extractClaim(token, Claims::getExpiration);
	                return expDate.before(new Date());
	    
		   
	   }
    // token is valid or not

	 public boolean isTokenValid(String token, String username) {
		  String usernameFromToken = extractUsername(token);
		  return usernameFromToken.equals(username);
		 
	 }
    
   
}
