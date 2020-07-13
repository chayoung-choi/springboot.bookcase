package com.cyoung90.bookcase.domain.books;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.cyoung90.bookcase.config.auth.LoginUser;
import com.cyoung90.bookcase.config.auth.dto.SessionUser;
import com.cyoung90.bookcase.domain.BaseTimeEntity;
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
	private String id;
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
	private String updated_user;
	
	@Builder
	public Books(String id, String bookcase_id, String title, String contents, LocalDateTime datetime,
			String isbn, Long price, String publisher, Long sale_price, String thumbnail, String url,
			String create_user, String updated_user) {
		this.id = id;
		this.bookcase_id = bookcase_id;
		this.title = title;
		this.contents = contents;
		this.datetime = datetime;
		this.isbn = isbn;
		this.price = price;
		this.publisher = publisher;
		this.sale_price = sale_price;
		this.thumbnail = thumbnail;
		this.url = url;
		this.create_user = create_user;
		this.updated_user = updated_user;
	}
	
}