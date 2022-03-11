package com.simpleapi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simpleapi.api.entity.User;
import com.simpleapi.api.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }
	
    @PostMapping("/user")
	public User createUser(@RequestBody User user) {
    	return userService.saveUser(user);
	}
}
