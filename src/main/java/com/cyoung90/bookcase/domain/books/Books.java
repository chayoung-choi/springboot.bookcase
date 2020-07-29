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
	private String bookId;
	private String bookcaseId;
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
	
	private String useYn;
	private String createUser;
	private String updatedUser;
	
	@Builder
	public Books(String bookId, String bookcaseId, String title, List<String> authors, String contents,
			LocalDateTime datetime, String isbn, Long price, String publisher, String thumbnail, String url,
			String useYn, String createUser, String updatedUser) {
		this.bookId = bookId;
		this.bookcaseId = bookcaseId;
		this.title = title;
		this.authors = authors;
		this.contents = contents;
		this.datetime = datetime;
		this.isbn = isbn;
		this.price = price;
		this.publisher = publisher;
		this.thumbnail = thumbnail;
		this.url = url;
		this.useYn = useYn;
		this.createUser = createUser;
		this.updatedUser = updatedUser;
	}
}