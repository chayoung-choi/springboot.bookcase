package com.cyoung90.bookcase.web.books.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BooksRentalRequestDto {
	
	private String book_id;
	private String sessionId;

	@Builder
	public BooksRentalRequestDto(String book_id) {
		this.book_id = book_id;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
