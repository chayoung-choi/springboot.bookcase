package com.cyoung90.bookcase.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyoung90.bookcase.config.auth.LoginUser;
import com.cyoung90.bookcase.config.auth.dto.SessionUser;
import com.cyoung90.bookcase.domain.books.BooksRepository;
import com.cyoung90.bookcase.web.books.dto.BooksListResponseDto;
import com.cyoung90.bookcase.web.books.dto.BooksSaveRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BooksService {
	
	private final BooksRepository booksRepository;
	
	@Transactional
	public String rental(BooksSaveRequestDto requestDto) {
		return booksRepository.save(requestDto.toEntity()).getId();
	}
	
	@Transactional(readOnly = true) // 조회 기능일 때 조회속도 개선
	public List<BooksListResponseDto> findAllDesc() {
		return booksRepository.findAllDesc().stream().map(BooksListResponseDto::new).collect(Collectors.toList());
	}
}
