package com.rochano.runningapp.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.rochano.runningapp.model.User;

public interface UserServiceIf extends UserDetailsService {
	public void addUser(User user) throws Exception;
	public void updateUser(User user) throws Exception;
	public User getUserByEmail(String email);
	public User getUserById(int userId);
}
