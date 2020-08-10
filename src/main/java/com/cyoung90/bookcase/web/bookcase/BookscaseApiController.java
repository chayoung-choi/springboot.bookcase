package com.cyoung90.bookcase.web.bookcase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cyoung90.bookcase.config.auth.LoginUser;
import com.cyoung90.bookcase.config.auth.dto.SessionUser;
import com.cyoung90.bookcase.service.bookcase.BookcaseService;
import com.cyoung90.bookcase.web.bookcase.dto.BookcaseSaveRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BookscaseApiController {
	
	private final Log log = LogFactory.getLog(this.getClass());
	
	private final BookcaseService bookcaseService;
	
	@PostMapping("/api/v1/bookcase/save")
	public String save(@RequestBody BookcaseSaveRequestDto requestDto, @LoginUser SessionUser user) {
		requestDto.setSessionId(user.getUserId());
		return bookcaseService.save(requestDto);
	}
}
