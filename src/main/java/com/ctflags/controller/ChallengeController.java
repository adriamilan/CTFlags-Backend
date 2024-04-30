package com.ctflags.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ctflags.entities.Challenge;
import com.ctflags.services.ChallengeService;

@RestController
public class ChallengeController {
	
	@Autowired
	ChallengeService challengeService;
	
	@GetMapping("/challenges")
	public List<Challenge> getChallenges() {
		return challengeService.findAllChallenges();
	}
	
	@PostMapping("/challenge") 
	public Challenge saveChallenge(@RequestBody Challenge challenge) {
		System.out.println(challenge);
		return challengeService.saveChallenge(challenge);
	}
}
