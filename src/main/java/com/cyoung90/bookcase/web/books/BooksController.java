package com.cyoung90.bookcase.web.books;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BooksController {
	
	private final Log log = LogFactory.getLog(this.getClass());
	
	@GetMapping("/books/management")
	public String booksManagement(Model model) {
		
		return "books/management";
	}
	
}
