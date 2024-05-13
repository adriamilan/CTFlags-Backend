package com.ctflags.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.ctflags.entities.User;
import com.ctflags.services.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public List<User> getUsers() {
		
		return userService.findAllUsers();
	}
	
	@GetMapping("/user/{id}")
	public Optional<User> getUserById(@PathVariable String id) {
		
		return userService.findUserById(id);
	}
	
	@PostMapping("/user")
	public ResponseEntity<?> saveUser(@RequestBody User user) {
	    try {
	        // Verificar campos obligatorios
	        if (user.getId() == null) {
	            return ResponseEntity.badRequest().body("El id es obligatorio.");
	        }
	        if (user.getUsername() == null) {
	            return ResponseEntity.badRequest().body("El nombre de usuario es obligatorio.");
	        }
	        if (user.getEmail() == null) {
	            return ResponseEntity.badRequest().body("El correo electrónico es obligatorio.");
	        }
	        if (user.getProfile_pic() == null) {
	            return ResponseEntity.badRequest().body("La imagen de perfil es obligatoria.");
	        }

	        // Establecer valores por defecto para campos opcionales
	        if (user.getPoints() == null) {
	            user.setPoints(0);
	        }
	        if (user.getLinkedin_url() == null) {
	            user.setLinkedin_url("");
	        }
	        if (user.getGithub_url() == null) {
	            user.setGithub_url("");
	        }
	        if (user.getHackthebox_url() == null) {
	            user.setHackthebox_url("");
	        }
	        // Continuar verificando y estableciendo valores por defecto para otros campos opcionales si es necesario...

	        // Guardar el usuario y devolver la respuesta adecuada
	        String savedUser = userService.saveUser(user);
	        return ResponseEntity.ok(savedUser);
	    } catch (Exception e) {
	        // Manejar cualquier excepción y devolver una respuesta de error
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el usuario: " + e.getMessage());
	    }
	}


	
  	@GetMapping("/ranking")
      public List<User> getAllTopUsers() {
          return userService.getAllTopUsers();
	}
	
	@GetMapping("/ranking/{limit}")
	public Optional<List<User>> getTopUsers(@PathVariable int limit) {
		System.out.println(limit);
		return Optional.ofNullable(userService.getTopUsers(limit));
	}
	
	@DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUserById(id);
    }
	
	@PutMapping("/user/{id}")
	public ResponseEntity<String> updateUser(@PathVariable String id, @RequestBody User updatedUser) {
	    Optional<User> existingUserOptional = userService.findUserById(id);
	    if (existingUserOptional.isPresent()) {
	        User existingUser = existingUserOptional.get();
	        existingUser.setUsername(updatedUser.getUsername());
	        existingUser.setEmail(updatedUser.getEmail());
	        existingUser.setProfile_pic(updatedUser.getProfile_pic());
	        existingUser.setLinkedin_url(updatedUser.getLinkedin_url());
	        existingUser.setGithub_url(updatedUser.getGithub_url());
	        existingUser.setHackthebox_url(updatedUser.getHackthebox_url());
	        existingUser.setPoints(updatedUser.getPoints());
	        existingUser.setRole(updatedUser.getRole());
	        
	        String savedUser = userService.saveUser(existingUser);
	        
	        return ResponseEntity.ok(savedUser);
	    } else {
	        throw new ResourceNotFoundException("User not found with id: " + id);
	    }
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class ResourceNotFoundException extends RuntimeException {
	    private static final long serialVersionUID = 1L;

	    public ResourceNotFoundException(String message) {
	        super(message);
	    }
	}


}
