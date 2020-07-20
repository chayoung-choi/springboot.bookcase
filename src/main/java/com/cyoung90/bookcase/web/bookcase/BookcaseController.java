package com.cyoung90.bookcase.web.bookcase;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cyoung90.bookcase.config.auth.LoginUser;
import com.cyoung90.bookcase.config.auth.dto.SessionUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BookcaseController {
	@GetMapping("/bookcase")
	public String bookcase(Model model, @LoginUser SessionUser user) {
		
		model.addAttribute("user", user);
		return "bookcase/index";
	}
}
