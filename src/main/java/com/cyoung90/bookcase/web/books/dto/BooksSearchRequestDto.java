package com.cyoung90.bookcase.web.books.dto;

import com.cyoung90.bookcase.domain.books.Books;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BooksSearchRequestDto {
	
	private String bookId;
	private String title;
	private String sessionId;

	@Builder
	public BooksSearchRequestDto(String book_id) {
		this.bookId = book_id;
	}

	public Books toEntity() {
		return Books.builder().bookId(bookId).title(title).build();
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
