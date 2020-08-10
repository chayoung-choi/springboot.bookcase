package com.cyoung90.bookcase.web.books.dto;

import com.cyoung90.bookcase.domain.books.Books;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BooksSearchRequestDto {
	
	private String title;
	

	@Builder
	public BooksSearchRequestDto(String title) {
		this.title = title;
	}

	public Books toEntity() {
		return Books.builder().title(title).build();
	}

}
