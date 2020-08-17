package com.cyoung90.bookcase.web.books.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Convert;

import com.cyoung90.bookcase.domain.books.Books;
import com.cyoung90.bookcase.utils.StringListConverter;

import lombok.Getter;

@Getter
public class BooksResponseDto {
	private String bookId;
	private String bookcaseId;
	private String title;
	
	private String contents;
	
	@Convert(converter = StringListConverter.class)
	private List<String> authors;
	
	private LocalDate datetime;
	private String isbn;
	
	private Long price;
	private String publisher;

	private String thumbnail;
	private String url;
	private String createUser;

   public BooksResponseDto(Books entity) {
	   this.bookId = entity.getBookId();
	   this.bookcaseId = entity.getBookcaseId();
	   this.title = entity.getTitle();
	   this.contents = entity.getContents();
	   this.authors = entity.getAuthors();
	   this.datetime = LocalDate.from(entity.getDatetime());
	   this.isbn = entity.getIsbn();
	   this.price = entity.getPrice();
	   this.publisher = entity.getPublisher();
	   this.thumbnail = entity.getThumbnail();
	   this.url = entity.getUrl();
	   this.createUser = entity.getCreateUser();
   }
}