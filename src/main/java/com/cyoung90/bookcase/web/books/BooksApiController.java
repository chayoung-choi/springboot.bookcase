package com.cyoung90.bookcase.web.books;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cyoung90.bookcase.config.auth.LoginUser;
import com.cyoung90.bookcase.config.auth.dto.SessionUser;
import com.cyoung90.bookcase.service.BookcaseService;
import com.cyoung90.bookcase.service.BooksService;
import com.cyoung90.bookcase.web.bookcase.dto.BookcaseResponseDto;
import com.cyoung90.bookcase.web.books.dto.BooksSaveRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BooksApiController {
	
	private final Log log = LogFactory.getLog(this.getClass());
	
	private final BooksService booksService;
	
	private final BookcaseService bookcaseService;
	
	@PostMapping("/api/v1/book/save")
	public String save(@RequestBody BooksSaveRequestDto requestDto, @LoginUser SessionUser user) {
		requestDto.setSessionId(user.getUserId());
		return booksService.save(requestDto);
	}
	
	@PostMapping("/api/v1/book/rental")
	public String rental(@RequestBody BooksSaveRequestDto requestDto, @LoginUser SessionUser user) {
		requestDto.setSessionId(user.getUserId());
		return booksService.rental(requestDto);
	}
	
	@PostMapping("/api/v1/book/register")
	public String register(@RequestBody BooksSaveRequestDto requestDto, @LoginUser SessionUser user) {
		BookcaseResponseDto bookcaseResponseDto = bookcaseService.findByUserId(user.getUserId());
		requestDto.setBookcase_id(bookcaseResponseDto.getBookcaseId());
		requestDto.setSessionId(user.getUserId());
		return booksService.rental(requestDto);
	}
}
