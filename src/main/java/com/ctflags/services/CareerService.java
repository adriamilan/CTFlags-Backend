package com.ctflags.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctflags.entities.Career;
import com.ctflags.repository.CareerRepository;

@Service
public class CareerService {

	@Autowired
	CareerRepository careerRepository;
	
	public List<Career> findAllCareer(){
		return careerRepository.findAll();
	}
	
	public Optional<Career> findCareerById(Long id) {

		Optional<Career> career = careerRepository.findById(id);
		
		return career;
	}

	public Career saveCareer(Career career) {
		return careerRepository.save(career);
	}
	
	public void deleteCareerById(Long id) {
	    careerRepository.deleteById(id);
	}
}
