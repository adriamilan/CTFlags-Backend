package com.ctflags.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctflags.dtos.UserDTO;
import com.ctflags.entities.User;
import com.ctflags.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<UserDTO> findAllUsers() {

		List<User> users = userRepository.findAll();

		List<UserDTO> usersDTO = new ArrayList<UserDTO>();

		users.forEach((user) -> {
			UserDTO userDTO = new UserDTO();
			userDTO.setUsername(user.getUsername());
			userDTO.setEmail(user.getEmail());
			userDTO.setPoints(user.getPoints());
			userDTO.setRole_id(user.getRoleId());

			usersDTO.add(userDTO);
		});

		return usersDTO;
	}

	public UserDTO findUserById(Long id) {

		Optional<User> userOptional = userRepository.findById(id);
		if (userOptional.isPresent()) {
			User user = userOptional.get();
			UserDTO userDTO = new UserDTO();
			userDTO.setUsername(user.getUsername());
			userDTO.setEmail(user.getEmail());
			userDTO.setPoints(user.getPoints());
			userDTO.setRole_id(user.getRoleId());
			return userDTO;
		}
		return null;
	}

	public String saveUser(User user) {
		System.out.println(user.getRoleId());
		userRepository.save(user);
		return "User added successfully!";
	}

}
