package com.cyoung90.bookcase.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyoung90.bookcase.domain.books.BooksRepository;
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
}
