package com.user.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.main.model.User;
import com.user.main.service.UserService;
import com.user.main.valueObject.ResponseTemplate;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		
		return userService.saveUser(user);
	}
	
	// In this method to get the user along with the department
	//for this we need to create wrapper object
	// wrapper object: It will contain user and department both
	@GetMapping("/{id}")
	public ResponseTemplate getUserWithDepartment(@PathVariable("id") Long userId) {
		return userService.getUserWithDepartment(userId);
	}
}
