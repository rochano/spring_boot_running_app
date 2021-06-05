package com.rochano.runningapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rochano.runningapp.model.User;
import com.rochano.runningapp.service.UserServiceIf;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserServiceIf userService;

	@RequestMapping(value = "adduser", method = RequestMethod.POST)
	public void addUser(@RequestBody User user) throws Exception {
		userService.addUser(user);
	}

	@RequestMapping(value = "/updateuser", method = RequestMethod.POST)
	public void updateUser(@RequestBody User user) throws Exception {
		userService.updateUser(user);
	}

	@RequestMapping(value = "getuser/{userId}", method = RequestMethod.GET)
	public User getUser(@PathVariable int userId) throws Exception {
		return userService.getUserById(userId);
	}
}
