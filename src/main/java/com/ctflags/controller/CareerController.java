package com.ctflags.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@DeleteMapping("/career/{id}")
	public void deleteCareer(@PathVariable Long id) {
	    careerService.deleteCareerById(id);
	}
}
