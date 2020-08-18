package com.cyoung90.bookcase.service.books;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyoung90.bookcase.domain.books.rental.BooksRentalRepository;
import com.cyoung90.bookcase.web.books.dto.BooksRentalSaveRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BooksRentalService {

	private final BooksRentalRepository booksRentalRepository;

	@Transactional
	public String save(BooksRentalSaveRequestDto requestDto) {
		return booksRentalRepository.save(requestDto.toEntity()).getBookId();
	}
	
}
