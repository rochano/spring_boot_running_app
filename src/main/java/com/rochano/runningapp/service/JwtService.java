package com.rochano.runningapp.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.rochano.runningapp.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {
	@Value("${SECRET_KEY}")
	private String secret;

	public String getJWT(User user) {
		Map<String, Object> claims = new HashMap<>();

		String jwt = Jwts.builder().setClaims(claims)
				.setId(String.valueOf(user.getUserId()))
				.setSubject(user.getEmail())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 360000))
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
		return jwt;
	}

	public Boolean isValidToken(String token, UserDetails userDetail) {
		final String userId = extractClaim(token, Claims::getSubject);
		return (userId.equals(String.valueOf(userDetail.getUsername()))
				&& !extractClaim(token, Claims::getExpiration).before(new Date()));
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		return claimsResolver.apply(claims);
	}
}
