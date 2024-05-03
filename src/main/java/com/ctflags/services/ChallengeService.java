package com.ctflags.services;

import java.util.List;
import java.util.Optional;

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

	public Optional<Challenge> findChallengeById(Long id) {

		Optional<Challenge> challenge = challengeRepository.findById(id);
		
		return challenge;
	}
	
	public Challenge saveChallenge(Challenge challenge) {
		return challengeRepository.save(challenge);
	}

	public void deleteChallengeById(Long id) {
	    challengeRepository.deleteById(id);
	}

}
