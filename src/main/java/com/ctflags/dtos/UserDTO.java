package com.ctflags.dtos;

import lombok.Data;

@Data
public class UserDTO {
	
	String username;
	String email;
	String profile_pic;
	String linkedin_url;
	String github_url;
	String hackthebox_url;
	Integer points;
	Integer role_id;
}
