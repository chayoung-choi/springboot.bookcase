package com.cyoung90.bookcase.service.books;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyoung90.bookcase.domain.books.Books;
import com.cyoung90.bookcase.domain.books.BooksRepository;
import com.cyoung90.bookcase.domain.books.rental.BooksRental;
import com.cyoung90.bookcase.domain.books.rental.BooksRentalRepository;
import com.cyoung90.bookcase.web.books.dto.BooksListResponseDto;
import com.cyoung90.bookcase.web.books.dto.BooksResponseDto;
import com.cyoung90.bookcase.web.books.dto.BooksSaveRequestDto;
import com.cyoung90.bookcase.web.books.dto.BooksSearchRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BooksService {

	private final BooksRepository booksRepository;
	
	private final BooksRentalRepository booksRentalRepository;

	@Transactional
	public String save(BooksSaveRequestDto requestDto) {
		return booksRepository.save(requestDto.toEntity()).getBookId();
	}

	@Transactional
	public String rental(BooksSearchRequestDto requestDto) {
		Books book = booksRepository.findById(requestDto.getBookId())
				.orElseThrow(() -> new IllegalArgumentException("해당 정보가 없습니다."));
		System.out.println("booksRentalRepository.getRentalMaxSeq() >> " + booksRentalRepository.getRentalMaxSeq());
		BooksRental bookRental = new BooksRental();
		bookRental.setBookId(book.getBookId());
		bookRental.setTitle(book.getTitle());
		bookRental.setRentalSeq(booksRentalRepository.getRentalMaxSeq());
		bookRental.setBookcaseId(book.getBookcaseId());
		bookRental.setStatus("대여중");
		bookRental.setRentalDate(LocalDateTime.now());
		booksRentalRepository.save(bookRental);
		return booksRepository.save(book).getBookId();
	}

	@Transactional(readOnly = true) // 조회 기능일 때 조회속도 개선
	public List<BooksListResponseDto> findAllDesc() {
		return booksRepository.findAllDesc().stream().map(BooksListResponseDto::new).collect(Collectors.toList());
	}

	@Transactional(readOnly = true) // 조회 기능일 때 조회속도 개선
	public List<BooksListResponseDto> findAllByBookcaseIdDesc(String bookcaseId) {
		return booksRepository.findAllByBookcaseIdDesc(bookcaseId).stream().map(BooksListResponseDto::new)
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true) // 조회 기능일 때 조회속도 개선
	public List<BooksResponseDto> findAllByBookcaseIdAndTitleContainingOrderByUpdatedDateDesc(String bookcaseId, String title) {
		return booksRepository.findAllByBookcaseIdAndTitleContainingOrderByUpdatedDateDesc(bookcaseId, title).stream().map(BooksResponseDto::new)
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true) // 조회 기능일 때 조회속도 개선
	public BooksResponseDto findByBookId(String bookId) {
			Books entity = booksRepository.findById(bookId) 
					.orElseThrow(() -> new IllegalArgumentException("해당 도서 정보가 없습니다."));
			return new BooksResponseDto(entity);
	}
}
