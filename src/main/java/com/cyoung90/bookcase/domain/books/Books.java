package com.cyoung90.bookcase.domain.books;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.cyoung90.bookcase.domain.BaseTimeEntity;

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
	private String id;
	private String bookcase_id;
	private String title;
	private String authors;
	private String contents;
	private LocalDateTime datetime;
	private String isbn;
	private Number price;
	private String publisher;
	private Number sale_price;
	private String status;
	private String thumbnail;
	private String url;
	private String create_user;
	private String updated_user;
	
	@Builder
	public Books(String title, String authors, String contents) {
		this.title = title;
		this.authors = authors;
		this.contents = contents;
	}
}
