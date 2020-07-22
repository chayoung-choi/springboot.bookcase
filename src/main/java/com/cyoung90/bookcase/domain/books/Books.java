package com.cyoung90.bookcase.domain.books;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.cyoung90.bookcase.domain.BaseTimeEntity;
import com.cyoung90.bookcase.utils.StringListConverter;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity(name = "TB2_BOOKS")
public class Books extends BaseTimeEntity {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String book_id;
	private String bookcase_id;
	private String title;
	
	@Convert(converter = StringListConverter.class)
	@Column(name = "authors")
	private List<String> authors;
	private String contents;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	private LocalDateTime datetime;
	private String isbn;
	
	private Long price;
	private String publisher;
	private String thumbnail;
	private String url;
	
	private String use_yn;
	private String create_user;
	private String updated_user;
	
	@Builder
	public Books(String book_id, String bookcase_id, String title, List<String> authors, String contents, LocalDateTime datetime,
			String isbn, Long price, String publisher, String thumbnail, String url, String use_yn,
			String create_user, String updated_user) {
		this.book_id = book_id;
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
		this.use_yn = use_yn;
		this.create_user = create_user;
		this.updated_user = updated_user;
	}
	
}