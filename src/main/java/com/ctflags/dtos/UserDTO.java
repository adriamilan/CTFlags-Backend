package com.ctflags.dtos;

import lombok.Data;

@Data
public class UserDTO {
	
	String username;
	String email;
	String profile_pic;
	Integer points;
	Integer role_id;
}
