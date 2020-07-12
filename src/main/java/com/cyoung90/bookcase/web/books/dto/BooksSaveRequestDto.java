package com.cyoung90.bookcase.web.books.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.cyoung90.bookcase.domain.books.Books;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BooksSaveRequestDto {
	private String bookcase_id;
	private String title;
	private String[] authors;
	private String contents;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	private LocalDateTime datetime;
	private String isbn;
	private Number price;
	private String publisher;
	private Number sale_price;
	private String status;
	private String thumbnail;
	private String url;
	private String create_user;

	@Builder
	public BooksSaveRequestDto(String bookcase_id, String title, String[] authors, String contents,
			LocalDateTime datetime, String isbn, Number price, String publisher, Number sale_price, String status,
			String thumbnail, String url, String create_user) {
		this.bookcase_id = bookcase_id;
		this.title = title;
		this.authors = authors;
		this.contents = contents;
		this.datetime = datetime;
		this.isbn = isbn;
		this.price = price;
		this.publisher = publisher;
		this.sale_price = sale_price;
		this.status = status;
		this.thumbnail = thumbnail;
		this.url = url;
		this.create_user = create_user;
	}

	public Books toEntity() {
		return Books.builder().bookcase_id(bookcase_id).title(title).authors(authors).contents(contents)
				.datetime(datetime).isbn(isbn).price(price).publisher(publisher).sale_price(sale_price).status(status)
				.thumbnail(thumbnail).url(url).create_user(create_user).build();
	}

	@Override
	public String toString() {
		return "BooksSaveRequestDto [bookcase_id=" + bookcase_id + ", title=" + title + ", authors=" + authors
				+ ", contents=" + contents + ", datetime=" + datetime + ", isbn=" + isbn + ", price=" + price
				+ ", publisher=" + publisher + ", sale_price=" + sale_price + ", status=" + status + ", thumbnail="
				+ thumbnail + ", url=" + url + ", create_user=" + create_user + "]";
	}

}
