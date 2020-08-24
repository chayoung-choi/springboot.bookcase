package com.cyoung90.bookcase.service.books;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyoung90.bookcase.domain.books.rental.BooksRental;
import com.cyoung90.bookcase.domain.books.rental.BooksRentalRepository;
import com.cyoung90.bookcase.domain.posts.Posts;
import com.cyoung90.bookcase.web.books.dto.BooksRentalResponseDTO;
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
	
	@Transactional(readOnly = true) // 조회 기능일 때 조회속도 개선
	public List<BooksRentalResponseDTO> findAllByUserId(String userId) {
		return booksRentalRepository.findAllByUserId(userId).stream().map(BooksRentalResponseDTO::new)
				.collect(Collectors.toList());
	}
	
	@Transactional
	public String returnBook(String bookId, String userId) {
		BooksRental booksRental = booksRentalRepository.findByBookIdAndUserId(bookId, userId);
		if (booksRental == null) {
			new IllegalArgumentException("대여 정보가 없습니다.");
		}
		
		booksRental.returnBook(userId);
		return bookId;
	}
	
}
