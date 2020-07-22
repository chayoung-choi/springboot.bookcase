package com.cyoung90.bookcase.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyoung90.bookcase.domain.bookcase.BookcaseRepository;
import com.cyoung90.bookcase.web.bookcase.dto.BookcaseListResponseDto;
import com.cyoung90.bookcase.web.bookcase.dto.BookcaseSaveRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookcaseService {
	
	private final BookcaseRepository bookcaseRepository;
	
	@Transactional
	public String save(BookcaseSaveRequestDto requestDto) {
		return bookcaseRepository.save(requestDto.toEntity()).getBookcaseId();
	}
	
//	@Transactional
//	public String rental(BooksSaveRequestDto requestDto) {
//		return booksRepository.save(requestDto.toEntity()).getBook_id();
//	}
//	
	@Transactional(readOnly = true) // 조회 기능일 때 조회속도 개선
	public List<BookcaseListResponseDto> findAllDesc() {
		return bookcaseRepository.findAllDesc().stream().map(BookcaseListResponseDto::new).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true) // 조회 기능일 때 조회속도 개선
	public List<BookcaseListResponseDto> findAllByUserId(String userId) {
		return bookcaseRepository.findAllByUserId(userId).stream().map(BookcaseListResponseDto::new).collect(Collectors.toList());
	}
	
//	@Transactional(readOnly = true) // 조회 기능일 때 조회속도 개선
//	public List<BooksListResponseDto> findAllDesc() {
//		return booksRepository.findAllDesc().stream().map(BooksListResponseDto::new).collect(Collectors.toList());
//	}
}
