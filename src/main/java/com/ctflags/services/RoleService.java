package com.ctflags.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctflags.dtos.RoleDTO;
import com.ctflags.entities.Role;
import com.ctflags.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	RoleRepository roleRepository;
	
	public List<RoleDTO> findAllRoles() {
		
		List<Role> roles = roleRepository.findAll();
		List<RoleDTO> rolesDTO = new ArrayList<RoleDTO>();
		
		roles.forEach((role) -> {
			RoleDTO roleDTO = new RoleDTO();
			roleDTO.setName(role.getName());
			rolesDTO.add(roleDTO);
		});
		return rolesDTO;
	}
	
	public String saveRole(Role role) {
		
		roleRepository.save(role);
		return "Role ha sido guardado con exito!";
	}
}
