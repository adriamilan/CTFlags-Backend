package com.ctflags.services;

import java.util.List;

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

	public Career saveCareer(Career career) {
		return careerRepository.save(career);
	}
	
}
