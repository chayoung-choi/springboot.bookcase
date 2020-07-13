package com.cyoung90.bookcase.web.books.dto;

import java.time.LocalDateTime;

import com.cyoung90.bookcase.domain.books.Books;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
public class BooksListResponseDto {
	private String bookcase_id;
	private String title;
	private String contents;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	private LocalDateTime datetime;
	private String isbn;
	
	private Long price;
	private String publisher;

	private Long sale_price;
	private String thumbnail;
	private String url;
	private String create_user;

   public BooksListResponseDto(Books entity) {
	   this.bookcase_id = entity.getBookcase_id();
	   this.title = entity.getTitle();
	   this.contents = entity.getContents();
	   this.datetime = entity.getDatetime();
	   this.isbn = entity.getIsbn();
	   this.price = entity.getPrice();
	   this.publisher = entity.getPublisher();
	   this.sale_price = entity.getSale_price();
	   this.thumbnail = entity.getThumbnail();
	   this.url = entity.getUrl();
	   this.create_user = entity.getCreate_user();
   }
}