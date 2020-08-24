package com.cyoung90.bookcase.web.books;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cyoung90.bookcase.config.auth.LoginUser;
import com.cyoung90.bookcase.config.auth.dto.SessionUser;
import com.cyoung90.bookcase.service.bookcase.BookcaseService;
import com.cyoung90.bookcase.service.books.BooksRentalService;
import com.cyoung90.bookcase.service.books.BooksService;
import com.cyoung90.bookcase.web.bookcase.dto.BookcaseResponseDto;
import com.cyoung90.bookcase.web.books.dto.BooksResponseDto;
import com.cyoung90.bookcase.web.books.dto.BooksSaveRequestDto;
import com.cyoung90.bookcase.web.books.dto.BooksSearchRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BooksApiController {

	private final Log log = LogFactory.getLog(this.getClass());

	private final BooksService booksService;
	
	private final BooksRentalService booksRentalService;

	private final BookcaseService bookcaseService;
	
	@PostMapping("/api/v1/book/save")
	public String save(@RequestBody BooksSaveRequestDto requestDto, @LoginUser SessionUser user) {
		requestDto.setSessionId(user.getUserId());
		return booksService.save(requestDto);
	}


	@PostMapping("/api/v1/book/register")
	public String register(@RequestBody BooksSaveRequestDto requestDto, @LoginUser SessionUser user) {
		BookcaseResponseDto bookcaseResponseDto = bookcaseService.findByUserId(user.getUserId());
		requestDto.setBookcase_id(bookcaseResponseDto.getBookcaseId());
		requestDto.setSessionId(user.getUserId());
		return booksService.save(requestDto);
	}

	@PostMapping("/api/v1/book/rental")
	public String bookRental(@RequestBody BooksSearchRequestDto requestDto, @LoginUser SessionUser user) {
		requestDto.setSessionId(user.getUserId());
		return booksService.rentalBook(requestDto);
	}
	
	@GetMapping("/api/v1/book/rental-search/{title}")
	public List<BooksResponseDto> rentalSearch(@PathVariable String title, @LoginUser SessionUser user) {
		String bookcaseId = "5e0ae788-79df-4a5f-bf5f-6ecb06b0fe11";
		log.info(user.getEmail() + " >> "+ title);
		return booksService.findAllByBookcaseIdAndTitleContainingOrderByUpdatedDateDesc(bookcaseId, title);
	}
	
	@PutMapping("/api/v1/book/return/{bookId}")
	public String returnBook(@PathVariable String bookId, @RequestBody BooksSearchRequestDto requestDto, @LoginUser SessionUser user) {
		return booksRentalService.returnBook(bookId, user.getUserId());
	}
}
