package com.rochano.runningapp.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rochano.runningapp.model.AuthResponse;
import com.rochano.runningapp.model.User;
import com.rochano.runningapp.service.JwtService;
import com.rochano.runningapp.service.UserServiceIf;

import io.jsonwebtoken.Claims;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserServiceIf userService;

	@Autowired
	private JwtService jwtService;

	@RequestMapping(value = "authenticate", method = RequestMethod.POST)
	public ResponseEntity getJwtAuthToken(@RequestBody User user) throws Exception {
		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("EMAIL_NOT_FOUND", e);
		}

		User existsUser = userService.getUserByEmail(user.getEmail());
		String jwt = jwtService.getJWT(existsUser);
		String userId = jwtService.extractClaim(jwt, Claims::getId);
		String email = jwtService.extractClaim(jwt, Claims::getSubject);
		Date expiration = jwtService.extractClaim(jwt, Claims::getExpiration);

		AuthResponse authResponse = new AuthResponse(userId, email, jwt, expiration);
		return new ResponseEntity<Object>(authResponse, new HttpHeaders(), HttpStatus.OK);
	}
}
