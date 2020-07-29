package com.cyoung90.bookcase.web.books.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Convert;

import com.cyoung90.bookcase.domain.books.Books;
import com.cyoung90.bookcase.utils.StringListConverter;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
public class BooksListResponseDto {
	private String bookId;
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
	private String createUser;

   public BooksListResponseDto(Books entity) {
	   this.bookId = entity.getBookId();
	   this.bookcaseId = entity.getBookcaseId();
	   this.title = entity.getTitle();
	   this.contents = entity.getContents();
	   this.authors = entity.getAuthors();
	   this.datetime = entity.getDatetime();
	   this.isbn = entity.getIsbn();
	   this.price = entity.getPrice();
	   this.publisher = entity.getPublisher();
	   this.thumbnail = entity.getThumbnail();
	   this.url = entity.getUrl();
	   this.createUser = entity.getCreateUser();
   }
}