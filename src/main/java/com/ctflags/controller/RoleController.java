package com.ctflags.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ctflags.dtos.RoleDTO;
import com.ctflags.entities.Role;
import com.ctflags.services.RoleService;

@RestController
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	@GetMapping("/roles")
	public List<RoleDTO> getRoles() {
		return roleService.findAllRoles();
	}
	
	@PostMapping("/role") 
	public String saveRole(@RequestBody Role role) {
		System.out.println(role);
		return roleService.saveRole(role);
	}
}
