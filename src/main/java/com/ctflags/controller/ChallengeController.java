package com.ctflags.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ctflags.entities.Challenge;
import com.ctflags.entities.User;
import com.ctflags.services.ChallengeService;

@RestController
public class ChallengeController {
	
	@Autowired
	ChallengeService challengeService;
	
	@GetMapping("/challenges")
	public List<Challenge> getChallenges() {
		return challengeService.findAllChallenges();
	}
	
	@GetMapping("/challenge/{id}")
	public Optional<Challenge> getChallengeById(@PathVariable Long id) {
		
		return challengeService.findChallengeById(id);
	}
	
	@PostMapping("/challenge") 
	public Challenge saveChallenge(@RequestBody Challenge challenge) {
		System.out.println(challenge);
		return challengeService.saveChallenge(challenge);
	}
}
