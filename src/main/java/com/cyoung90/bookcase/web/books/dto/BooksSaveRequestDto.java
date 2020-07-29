package com.cyoung90.bookcase.web.books.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Convert;

import com.cyoung90.bookcase.config.auth.LoginUser;
import com.cyoung90.bookcase.config.auth.dto.SessionUser;
import com.cyoung90.bookcase.domain.BaseTimeEntity;
import com.cyoung90.bookcase.domain.books.Books;
import com.cyoung90.bookcase.utils.StringListConverter;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BooksSaveRequestDto {
	
	private String bookcaseId;
	private String title;
	private String contents;
	
	@Convert(converter = StringListConverter.class)
	private List<String> authors;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	private LocalDateTime datetime;
	private String isbn;
	
	private Long price;
	private String publisher;
	private String thumbnail;
	private String url;
	private String useYn = "Y";
	
	private String sessionId;
	

	@Builder
	public BooksSaveRequestDto(String bookcase_id, String title, String contents, List<String> authors,
			LocalDateTime datetime, String isbn, Long price, String publisher, String thumbnail, String url) {
		this.bookcaseId = bookcase_id;
		this.title = title;
		this.authors = authors;
		this.contents = contents;
		this.datetime = datetime;
		this.isbn = isbn;
		this.price = price;
		this.publisher = publisher;
		this.thumbnail = thumbnail;
		this.url = url;
	}

	public Books toEntity() {
		return Books.builder().bookcaseId(bookcaseId).title(title).authors(authors).contents(contents)
				.datetime(datetime).isbn(isbn).price(price).publisher(publisher).thumbnail(thumbnail).url(url).useYn(useYn)
				.createUser(sessionId).updatedUser(sessionId).build();
	}
	
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
