package com.ctflags.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ctflags.entities.Career;
import com.ctflags.entities.Challenge;
import com.ctflags.services.CareerService;

@RestController
public class CareerController {
	
	@Autowired
	CareerService careerService;
	
	@GetMapping("/careers")
	public List<Career> getCareers() {
		return careerService.findAllCareer();
	}
	
	@PostMapping("/career") 
	public Career saveCareer(@RequestBody Career career) {
		System.out.println(career);
		return careerService.saveCareer(career);
	}
}
