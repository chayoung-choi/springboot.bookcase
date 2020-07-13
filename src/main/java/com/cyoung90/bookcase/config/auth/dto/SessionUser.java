package com.cyoung90.bookcase.config.auth.dto;

import java.io.Serializable;

import com.cyoung90.bookcase.domain.user.Role;
import com.cyoung90.bookcase.domain.user.User;

import lombok.Getter;

@Getter
public class SessionUser implements Serializable {
	
	/**
	 * system 발급 User 고유 id
	 */
	private String id; 
	private String name;
	private String email;
	private String picture;
	private Role role;

	public SessionUser(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.picture = user.getPicture();
		this.role = user.getRole();
	}
}