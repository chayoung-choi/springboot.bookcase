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
import com.cyoung90.bookcase.web.books.dto.BooksRentalResponseDTO;
import com.cyoung90.bookcase.web.books.dto.BooksRentalSaveRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BooksRentalService {

	private final BooksRentalRepository booksRentalRepository;
	
	private final BooksRepository booksRepository;
	
	@Transactional
	public String save(BooksRentalSaveRequestDto requestDto) {
		return booksRentalRepository.save(requestDto.toEntity()).getBookId();
	}
	
	@Transactional(readOnly = true) // 조회 기능일 때 조회속도 개선
	public List<BooksRentalResponseDTO> getBooksRentalList(String userId) {
		return booksRentalRepository.findAllByUserIdAndStatus(userId, "대여중").stream().map(BooksRentalResponseDTO::new)
				.collect(Collectors.toList());
	}

	@Transactional
	public String rentalBook(String bookId, String userId) {
		Books book = booksRepository.findById(bookId)
				.orElseThrow(() -> new IllegalArgumentException("해당 정보가 없습니다."));
		
		BooksRental booksRental = booksRentalRepository.findByBookIdAndUserIdAndStatus(bookId, userId, "대여중");
		if (booksRental != null) {
			throw new IllegalArgumentException("이미 대여중인 도서입니다.");
		}
		BooksRental bookRental = new BooksRental();
		bookRental.setBookId(book.getBookId());
		bookRental.setTitle(book.getTitle());
		bookRental.setRentalSeq(booksRentalRepository.getRentalMaxSeq(bookId));
		bookRental.setUserId(userId);
		bookRental.setBookcaseId(book.getBookcaseId());
		bookRental.setStatus("대여중");
		bookRental.setRentalDate(LocalDateTime.now());
		bookRental.setCreateUser(userId);
		bookRental.setUpdatedUser(userId);
		return booksRentalRepository.save(bookRental).getBookId();
	}
	
	@Transactional
	public String returnBook(String bookId, String userId) {
		BooksRental booksRental = booksRentalRepository.findByBookIdAndUserIdAndStatus(bookId, userId, "대여중");
		if (booksRental == null) {
			new IllegalArgumentException("대여 정보가 없습니다.");
		}
		
		booksRental.returnBook(userId);
		return bookId;
	}
	
}
