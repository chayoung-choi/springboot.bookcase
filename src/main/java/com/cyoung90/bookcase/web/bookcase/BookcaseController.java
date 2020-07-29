package com.cyoung90.bookcase.web.bookcase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cyoung90.bookcase.config.auth.LoginUser;
import com.cyoung90.bookcase.config.auth.dto.SessionUser;
import com.cyoung90.bookcase.domain.user.Role;
import com.cyoung90.bookcase.service.BookcaseService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BookcaseController {
	
	private final Log log = LogFactory.getLog(this.getClass());
	
	private final BookcaseService bookcaseService;
	
	@GetMapping("/bookcase")
	public String bookcase(Model model, @LoginUser SessionUser user) {
		
		model.addAttribute("user", user);
		model.addAttribute("bookcase", bookcaseService.findAllByUserId(user.getUserId()));
		return "bookcase/index";
	}

	@GetMapping("/bookcase/bookcase-save")
	public String bookcaseSave(Model model) {
		return "bookcase/bookcase-save";
	}
	
	@GetMapping("/bookcase/book/register/{bookcaseId}")
	public String bookRegister(Model model, @PathVariable String bookcaseId, @LoginUser SessionUser user) {
		bookcaseService.findByUserIdAndBookcaseId(user.getUserId(), bookcaseId);
		model.addAttribute("bookcaseId", bookcaseId);
		log.info(Role.USER.name());
		log.info(user.getRole().name());
		log.info(user.getRole().getTitle());
		return "bookcase/book-register";
	}
}
