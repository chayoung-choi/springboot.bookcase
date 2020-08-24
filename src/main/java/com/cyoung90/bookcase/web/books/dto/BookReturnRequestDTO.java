package com.cyoung90.bookcase.web.books.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Convert;

import com.cyoung90.bookcase.config.auth.LoginUser;
import com.cyoung90.bookcase.config.auth.dto.SessionUser;
import com.cyoung90.bookcase.domain.BaseTimeEntity;
import com.cyoung90.bookcase.domain.books.Books;
import com.cyoung90.bookcase.domain.books.rental.BooksRental;
import com.cyoung90.bookcase.utils.StringListConverter;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookReturnRequestDTO {
	
	private String bookId;
	private Integer rentalSeq;
	private String title;
	
	private String bookcaseId;
	private String status;
	private String sessionId;
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	private LocalDateTime rentalDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	private LocalDateTime returnDate;
	

	public BooksRental toEntity() {
		return BooksRental.builder().bookId(bookId).rentalSeq(rentalSeq).title(title).bookcaseId(bookcaseId)
				.status(status).userId(sessionId).rentalDate(rentalDate).returnDate(returnDate).createUser(sessionId)
				.updatedUser(sessionId).build();
	}

	@Builder
	public BookReturnRequestDTO(String bookId, Integer rentalSeq, String title, String bookcaseId, String status,
			String sessionId, LocalDateTime rentalDate, LocalDateTime returnDate) {
		this.bookId = bookId;
		this.rentalSeq = rentalSeq;
		this.title = title;
		this.bookcaseId = bookcaseId;
		this.status = status;
		this.sessionId = sessionId;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
