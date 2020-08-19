package com.cyoung90.bookcase.web.books.dto;

import java.time.LocalDateTime;

import com.cyoung90.bookcase.domain.books.rental.BooksRental;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
public class BooksRentalResponseDTO {
	private String bookId;
	private Integer rentalSeq;
	private String title;
	private String bookcaseId;
	private String status;
	private String userId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	private LocalDateTime renatlDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	private LocalDateTime returnDate;

	public BooksRentalResponseDTO(BooksRental entity) {
		this.bookId = entity.getBookId();
		this.rentalSeq = entity.getRentalSeq();
		this.title = entity.getTitle();
		this.bookcaseId = entity.getBookcaseId();
		this.status = entity.getStatus();
		this.userId = entity.getUserId();
		this.renatlDate = entity.getRentalDate();
		this.returnDate = entity.getReturnDate();
	}
}