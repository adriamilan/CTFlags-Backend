package com.ctflags.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

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
	
	@DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
	
	@PutMapping("/user/{id}")
	public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
	    Optional<User> existingUserOptional = userService.findUserById(id);
	    if (existingUserOptional.isPresent()) {
	        User existingUser = existingUserOptional.get();
	        existingUser.setUsername(updatedUser.getUsername());
	        existingUser.setEmail(updatedUser.getEmail());
	        existingUser.setPoints(updatedUser.getPoints());
	        existingUser.setRole(updatedUser.getRole());
	        
	        String savedUser = userService.saveUser(existingUser);
	        
	        return ResponseEntity.ok(savedUser);
	    } else {
	        throw new ResourceNotFoundException("User not found with id: " + id);
	    }
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class ResourceNotFoundException extends RuntimeException {
	    private static final long serialVersionUID = 1L;

	    public ResourceNotFoundException(String message) {
	        super(message);
	    }
	}


}
