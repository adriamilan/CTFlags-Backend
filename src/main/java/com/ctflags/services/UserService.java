package com.ctflags.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ctflags.entities.User;
import com.ctflags.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<User> findAllUsers() {

		List<User> users = userRepository.findAll();

		return users;
	}

	public Optional<User> findUserById(Long id) {

		Optional<User> user = userRepository.findById(id);
		
		return user;
	}

	public String saveUser(User user) {
		userRepository.save(user);
		return "User added successfully!";
	}

}
