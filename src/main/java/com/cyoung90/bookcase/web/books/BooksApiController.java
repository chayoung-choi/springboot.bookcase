package com.cyoung90.bookcase.web.books;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cyoung90.bookcase.config.auth.LoginUser;
import com.cyoung90.bookcase.config.auth.dto.SessionUser;
import com.cyoung90.bookcase.service.bookcase.BookcaseService;
import com.cyoung90.bookcase.service.bookcase.member.BookcaseMemberService;
import com.cyoung90.bookcase.service.books.BooksService;
import com.cyoung90.bookcase.web.bookcase.dto.BookcaseResponseDto;
import com.cyoung90.bookcase.web.bookcaseMember.dto.BookcaseMemberResponseDto;
import com.cyoung90.bookcase.web.books.dto.BooksSaveRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BooksApiController {

	private final Log log = LogFactory.getLog(this.getClass());

	private final BooksService booksService;

	private final BookcaseService bookcaseService;
	private final BookcaseMemberService bookcaseMemberService;

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

	@GetMapping("/api/v1/book/rental-search/{title}")
	public List<BookcaseMemberResponseDto> rentalSearch(@LoginUser SessionUser user, @PathVariable String title) {
		log.info(user.getEmail() + " >> "+ title);
		List<BookcaseMemberResponseDto> bookcaseMemberList = bookcaseMemberService
				.findAllByUserId(user.getUserId());
		return bookcaseMemberList;
	}
}
