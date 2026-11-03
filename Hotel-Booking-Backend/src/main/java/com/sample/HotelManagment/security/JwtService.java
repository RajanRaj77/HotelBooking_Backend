package com.sample.HotelManagment.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

	private static final String SECRET_KEY = "MySecretKeyForHotelBookingApplication2026JwtAuthentication";

	private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

	public String generateToken(String email) {

		return Jwts.builder().subject(email).issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + 86400000)).signWith(key, SignatureAlgorithm.HS256)
				.compact();
	}

	public String extractUsername(String token) {

		return extractClaim(token, Claims::getSubject);
	}

	public <T> T extractClaim(String token, Function<Claims, T> resolver) {

		Claims claims = Jwts.parser().verifyWith((javax.crypto.SecretKey) key).build().parseSignedClaims(token)
				.getPayload();

		return resolver.apply(claims);
	}

	public boolean isTokenValid(String token, String email) {

		return email.equals(extractUsername(token));
	}

}