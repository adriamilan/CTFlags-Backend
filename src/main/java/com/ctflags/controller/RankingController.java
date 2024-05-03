package com.ctflags.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctflags.entities.User;
import com.ctflags.services.RankingService;
import com.ctflags.services.UserService;

@RestController
public class RankingController {
	
	@Autowired
	RankingService rankingService;
	
	@GetMapping("/ranking")
	public List<User> getUsers() {
		
		return RankingService.rankingUsers();
	}

}
