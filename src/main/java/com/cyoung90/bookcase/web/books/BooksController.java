package com.cyoung90.bookcase.web.books;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cyoung90.bookcase.config.auth.LoginUser;
import com.cyoung90.bookcase.config.auth.dto.SessionUser;
import com.cyoung90.bookcase.domain.books.rental.BooksRental;
import com.cyoung90.bookcase.service.bookcase.BookcaseService;
import com.cyoung90.bookcase.service.books.BooksRentalService;
import com.cyoung90.bookcase.service.books.BooksService;
import com.cyoung90.bookcase.web.books.dto.BooksResponseDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BooksController {
	
	private final Log log = LogFactory.getLog(this.getClass());
	
	private final BooksService booksService;
	
	private final BookcaseService bookcaseService;
	
	private final BooksRentalService booksRentalService;
	
	@GetMapping("/books")
	public String booksManagement(Model model, @LoginUser SessionUser user) {
		model.addAttribute("user", user);
		model.addAttribute("books", booksService.findAllByBookcaseIdDesc("5e0ae788-79df-4a5f-bf5f-6ecb06b0fe11"));
		model.addAttribute("rental-books", booksRentalService.findAllByUserId(user.getUserId()));
		return "books/index";
	}
	
	@GetMapping("/books/book-save")
	public String bookSave(Model model, @LoginUser SessionUser user) {
		return "bookcase/book-save";
	}
	
	@GetMapping("/books/rental-search")
	public String rentalSearch(Model model) {
		return "books/books-rental-search";
	}
	
	@GetMapping("/books/book/{bookId}")
	public String book(Model model, @PathVariable String bookId, @LoginUser SessionUser user) {
		BooksResponseDto book = booksService.findByBookId(bookId);
		model.addAttribute("user", user);
		model.addAttribute("book", book);
		model.addAttribute("bookcase", bookcaseService.findByBookcaseId(book.getBookcaseId()));
		return "books/book";
	}
	
}
