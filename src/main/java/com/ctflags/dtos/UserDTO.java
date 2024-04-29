package com.ctflags.dtos;

import lombok.Data;

@Data
public class UserDTO {
	
	String username;
	String email;
	Integer points;
	Integer role_id;
}
