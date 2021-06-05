package com.rochano.runningapp.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rochano.runningapp.model.User;
import com.rochano.runningapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserServiceIf {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void addUser(User user) throws Exception {
		Optional<User> existsUser = userRepository.findByEmail(user.getEmail());
		if (existsUser.isPresent()) {
			throw new Exception("EMAIL_EXISTS");
		} else {
			userRepository.save(user);
		}
	}

	@Override
	public void updateUser(User user) throws Exception {
		Optional<User> existsUser = userRepository.findById(user.getUserId());
		if (!existsUser.isPresent()) {
			throw new Exception("USER_NOT_EXISTS");
		} else {
			userRepository.save(user);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> existsUser = userRepository.findByEmail(username);
		if (existsUser.isPresent()) {
			return new org.springframework.security.core.userdetails.User(existsUser.get().getEmail(),
					existsUser.get().getPassword(), new ArrayList());
		} else {
			throw new UsernameNotFoundException("EMAIL_NOT_FOUND");
		}
	}

	@Override
	public User getUserByEmail(String email) {
		Optional<User> existsUser = userRepository.findByEmail(email);
		if (existsUser.isPresent()) {
			return existsUser.get();
		} else {
			throw new UsernameNotFoundException("EMAIL_NOT_FOUND");
		}
	}

	@Override
	public User getUserById(int userId) {
		return userRepository.findById(userId).get();
	}
}
