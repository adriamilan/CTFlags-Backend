package com.ctflags.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctflags.entities.Challenge;
import com.ctflags.repository.ChallengeRepository;

@Service
public class ChallengeService {
	
	@Autowired
	ChallengeRepository challengeRepository;
	
	public List<Challenge> findAllChallenges(){
		return challengeRepository.findAll();
	}

	public Challenge saveChallenge(Challenge challenge) {
		return challengeRepository.save(challenge);
	}
}
