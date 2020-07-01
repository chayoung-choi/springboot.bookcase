package com.cyoung90.bookcase.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cyoung90.bookcase.config.auth.LoginUser;
import com.cyoung90.bookcase.config.auth.dto.SessionUser;
import com.cyoung90.bookcase.service.posts.PostService;
import com.cyoung90.bookcase.web.dto.PostsResponseDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AuthController {
	
	private final Log log = LogFactory.getLog(this.getClass());
	
	@GetMapping("/login")
	public String login(Model model, @LoginUser SessionUser user) {
		
		if (user != null) {
			model.addAttribute("userName", user.getName());
		}
		
		return "auth/login";
	}
}