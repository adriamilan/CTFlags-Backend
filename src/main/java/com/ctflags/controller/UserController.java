package com.ctflags.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ctflags.entities.User;
import com.ctflags.services.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public List<User> getUsers() {
		
		return userService.findAllUsers();
	}
	
	@GetMapping("/user/{id}")
	public Optional<User> getUserById(@PathVariable Long id) {
		
		return userService.findUserById(id);
	}
	
	@PostMapping("/user")
	public String saveUser(@RequestBody User user) {
		
		user.setPoints(0);
		return userService.saveUser(user);
	}
	
  	@GetMapping("/ranking")
      public List<User> getAllTopUsers() {
          return userService.getAllTopUsers();
	}
	
	@GetMapping("/ranking/{limit}")
	public Optional<List<User>> getTopUsers(@PathVariable int limit) {
		System.out.println(limit);
		return Optional.ofNullable(userService.getTopUsers(limit));
	}
	
//	@PutMapping("/user/{id}/add/points/{points}")
//	public String addUserPoints(@PathVariable Long id, @PathVariable Integer points) {
//		
//		return userService.addUserPoints(id, points);
//	}
}
