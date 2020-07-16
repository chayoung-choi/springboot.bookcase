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

@Getter
@NoArgsConstructor
public class BooksSaveRequestDto extends BaseTimeEntity {
	private String bookcase_id;
	private String title;
	private String contents;
	
	@Convert(converter = StringListConverter.class)
	private List<String> authors;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	private LocalDateTime datetime;
	private String isbn;
	
	private Long price;
	private String publisher;

	private Long sale_price;
	private String thumbnail;
	private String url;
	private String create_user;
	

	@Builder
	public BooksSaveRequestDto(String bookcase_id, String title, String contents, List<String> authors,
			LocalDateTime datetime, String isbn, Long price, String publisher, Long sale_price,
			String thumbnail, String url, String create_user, @LoginUser SessionUser user) {
		this.bookcase_id = bookcase_id;
		this.title = title;
		this.authors = authors;
		this.contents = contents;
		this.datetime = datetime;
		this.isbn = isbn;
		this.price = price;
		this.publisher = publisher;
		this.sale_price = sale_price;
		this.thumbnail = thumbnail;
		this.url = url;
		this.create_user = user.getEmail();
	}

	public Books toEntity() {
		return Books.builder().bookcase_id(bookcase_id).title(title).authors(authors).contents(contents)
				.datetime(datetime).isbn(isbn).price(price).publisher(publisher).sale_price(sale_price)
				.thumbnail(thumbnail).url(url).create_user(create_user).build();
	}

	@Override
	public String toString() {
		return "BooksSaveRequestDto [bookcase_id=" + bookcase_id + ", title=" + title
				+ ", contents=" + contents + ", datetime=" + datetime + ", isbn=" + isbn + ", price=" + price
				+ ", publisher=" + publisher + ", sale_price=" + sale_price + ", thumbnail="
				+ thumbnail + ", url=" + url + ", create_user=" + create_user + "]";
	}

}
