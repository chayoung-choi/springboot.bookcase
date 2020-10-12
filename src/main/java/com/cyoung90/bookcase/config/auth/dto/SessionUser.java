package com.cyoung90.bookcase.config.auth.dto;

import java.io.Serializable;

import com.cyoung90.bookcase.domain.user.Role;
import com.cyoung90.bookcase.domain.user.User;

import lombok.Getter;

@Getter
public class SessionUser implements Serializable {
	
	private static final long serialVersionUID = 7704928694331604736L;
	
	/**
	 * system 발급 User 고유 id
	 */
	private String userId; 
	private String name;
	private String nickname;
	private String email;
	private String picture;
	private String admin;
	private Role role;

	public SessionUser(User user) {
		this.userId = user.getUserId();
		this.name = user.getName();
		this.nickname = user.getNickname();
		this.email = user.getEmail();
		this.picture = user.getPicture();
		this.role = user.getRole();
		this.admin = ("ADMIN".equals(user.getRole().name()) ? "ADMIN새봄" : null);
	}
}