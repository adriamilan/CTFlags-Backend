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
            existingCareer.setName(updatedCareer.getName());
            existingCareer.setDescription(updatedCareer.getDescription());
            existingCareer.setCompany_name(updatedCareer.getCompany_name());
            existingCareer.setFecha(updatedCareer.getFecha());
            existingCareer.setProvincia(updatedCareer.getProvincia());
            existingCareer.setTeletrabajo(updatedCareer.isTeletrabajo());
            existingCareer.setPresencial(updatedCareer.isPresencial());
            existingCareer.setHibrido(updatedCareer.isHibrido());
            existingCareer.setSalario(updatedCareer.getSalario());
            existingCareer.setExperiencia(updatedCareer.getExperiencia());
            existingCareer.setJornada_laboral(updatedCareer.getJornada_laboral());
            existingCareer.setTipo_contrato(updatedCareer.getTipo_contrato());
            existingCareer.setImagen_base64(updatedCareer.getImagen_base64());
            existingCareer.setRole_id(updatedCareer.getRole_id());
            existingCareer.setChallenge_id(updatedCareer.getChallenge_id());
            
            Career savedCareer = careerService.saveCareer(existingCareer);
            
            return ResponseEntity.ok(savedCareer);
        } else {
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
