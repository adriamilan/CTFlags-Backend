package com.ctflags.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ctflags.entities.Career;
import com.ctflags.services.CareerService;

@RestController
public class CareerController {
	
	@Autowired
	CareerService careerService;
	
	@GetMapping("/careers")
	public List<Career> getCareers() {
		return careerService.findAllCareer();
	}
	
	@GetMapping("/career/{id}")
	public Optional<Career> getCareerById(@PathVariable Long id) {
		
		return careerService.findCareerById(id);
	}
	
	@PostMapping("/career") 
	public Career saveCareer(@RequestBody Career career) {
		System.out.println(career);
		return careerService.saveCareer(career);
	}
	
	@PutMapping("/career/{id}")
	public ResponseEntity<Career> updateCareer(@PathVariable Long id, @RequestBody Career updatedCareer) {
	    Optional<Career> existingCareerOptional = careerService.findCareerById(id);
	    if (existingCareerOptional.isPresent()) {
	        Career existingCareer = existingCareerOptional.get();
	        // Actualiza todos los campos de la carrera existente con los datos proporcionados
	        existingCareer.setName(updatedCareer.getName());
	        existingCareer.setDescription(updatedCareer.getDescription());
	        existingCareer.setCompany_name(updatedCareer.getCompany_name()); // Suponiendo que existe un método setCompanyName en la clase Career
	        existingCareer.setRole_id(updatedCareer.getRole_id()); // Suponiendo que existe un método setRoleId en la clase Career
	        existingCareer.setChallenge_id(updatedCareer.getChallenge_id()); // Suponiendo que existe un método setChallengeId en la clase Career
	        // Actualiza otros campos según sea necesario
	        
	        // Guarda la carrera actualizada
	        Career savedCareer = careerService.saveCareer(existingCareer);
	        
	        return ResponseEntity.ok(savedCareer);
	    } else {
	        // Si no se encuentra la carrera con el ID proporcionado, retorna un código de estado 404
	        throw new ResourceNotFoundException("Career not found with id: " + id);
	    }
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class ResourceNotFoundException extends RuntimeException {
	    private static final long serialVersionUID = 1L;

		public ResourceNotFoundException(String message) {
	        super(message);
	    }
	}

	
	@DeleteMapping("/career/{id}")
	public void deleteCareer(@PathVariable Long id) {
	    careerService.deleteCareerById(id);
	}
}
