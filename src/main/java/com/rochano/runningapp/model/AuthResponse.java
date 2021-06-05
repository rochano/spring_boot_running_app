package com.rochano.runningapp.model;

import java.util.Date;

public class AuthResponse {
	private String userId;
	private String email;
	private String jwt;
	private Date expiration;

	public AuthResponse(String userId, String email, String jwt, Date expiration) {
		super();
		this.userId = userId;
		this.email = email;
		this.jwt = jwt;
		this.expiration = expiration;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

}
