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
	
	private String bookcase_id = "1000";
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
	private String use_yn = "Y";
	
	private String create_user;
	private String updated_user;
	

	@Builder
	public BooksSaveRequestDto(String bookcase_id, String title, String contents, List<String> authors,
			LocalDateTime datetime, String isbn, Long price, String publisher, String thumbnail, String url) {
		this.bookcase_id = bookcase_id;
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
		return Books.builder().bookcase_id(bookcase_id).title(title).authors(authors).contents(contents)
				.datetime(datetime).isbn(isbn).price(price).publisher(publisher).thumbnail(thumbnail).url(url).use_yn(use_yn)
				.create_user(create_user).updated_user(updated_user).build();
	}

}
