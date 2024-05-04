package com.ctflags.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

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
	
	@GetMapping("/challenge/{id}")
	public Optional<Challenge> getChallengeById(@PathVariable Long id) {
		
		return challengeService.findChallengeById(id);
	}
	
	@PostMapping("/challenge") 
	public Challenge saveChallenge(@RequestBody Challenge challenge) {
		System.out.println(challenge);
		return challengeService.saveChallenge(challenge);
	}
	
	@PutMapping("/challenge/{id}")
    public ResponseEntity<Challenge> updateChallenge(@PathVariable Long id, @RequestBody Challenge updatedChallenge) {
        Optional<Challenge> existingChallengeOptional = challengeService.findChallengeById(id);
        if (existingChallengeOptional.isPresent()) {
            Challenge existingChallenge = existingChallengeOptional.get();
            // Actualiza todos los campos del desafío existente con los datos proporcionados
            existingChallenge.setName(updatedChallenge.getName());
            existingChallenge.setDescription(updatedChallenge.getDescription());
            existingChallenge.setFlag(updatedChallenge.getFlag());
            existingChallenge.setPoints(updatedChallenge.getPoints());
            existingChallenge.setDifficulty(updatedChallenge.getDifficulty());
            // Actualiza otros campos según sea necesario
            
            // Guarda el desafío actualizado
            Challenge savedChallenge = challengeService.saveChallenge(existingChallenge);
            
            return ResponseEntity.ok(savedChallenge);
        } else {
            // Si no se encuentra el desafío con el ID proporcionado, retorna un código de estado 404
            throw new ResourceNotFoundException("Challenge not found with id: " + id);
        }
    }

	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class ResourceNotFoundException extends RuntimeException {
	    private static final long serialVersionUID = 1L;

		public ResourceNotFoundException(String message) {
	        super(message);
	    }
	}
	
	@DeleteMapping("/challenge/{id}")
	public void deleteChallenge(@PathVariable Long id) {
	    challengeService.deleteChallengeById(id);
	}

}
