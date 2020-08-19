package com.cyoung90.bookcase.web.books.dto;

import com.cyoung90.bookcase.domain.books.Books;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BooksSearchRequestDto {
	
	private String book_id;
	private String title;
	private String sessionId;

	@Builder
	public BooksSearchRequestDto(String book_id) {
		this.book_id = book_id;
	}

	public Books toEntity() {
		return Books.builder().bookId(book_id).title(title).build();
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public String toString() {
		return "BooksSearchRequestDto [bookId=" + book_id + ", title=" + title + ", sessionId=" + sessionId + "]";
	}

}
