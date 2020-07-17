package com.cyoung90.bookcase.web.books;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cyoung90.bookcase.config.auth.LoginUser;
import com.cyoung90.bookcase.config.auth.dto.SessionUser;
import com.cyoung90.bookcase.service.BooksService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BooksController {
	
	private final Log log = LogFactory.getLog(this.getClass());
	private final BooksService booksService;
	
	@GetMapping("/books/management")
	public String booksManagement(Model model, @LoginUser SessionUser user) {
		
		model.addAttribute("user", user);
		model.addAttribute("rental", booksService.findAllDesc());
		return "books/management";
	}
	
	@GetMapping("/books/book-save")
	public String bookSave(Model model, @LoginUser SessionUser user) {
		return "bookcase/book-save";
	}
	
}
