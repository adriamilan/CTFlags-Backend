package com.ctflags.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctflags.entities.User;
import com.ctflags.repository.UserRepository;

@Service
public class RankingService {

	@Autowired
	private static UserRepository userRepository;

	public static List<User> rankingUsers() {
		List<User> users = userRepository.findAll();
		return users;
	}
	
}
