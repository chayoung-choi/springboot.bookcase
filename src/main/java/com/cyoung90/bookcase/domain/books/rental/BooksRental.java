package com.cyoung90.bookcase.domain.books.rental;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cyoung90.bookcase.domain.BaseTimeEntity;
import com.cyoung90.bookcase.domain.books.Books;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "TB2_BOOKS_RENTAL")
@IdClass(BooksRentalPK.class)
public class BooksRental extends BaseTimeEntity {
	@Id
	private String bookId;
	
	@Id
	private Integer rentalSeq;
	
	private String title;
	private String bookcaseId;
	private String status;
	private String userId;
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	private LocalDateTime rentalDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	private LocalDateTime returnDate;
	
	private String createUser;
	private String updatedUser;
	
	@ManyToOne(targetEntity = Books.class)
	@JoinColumn(name="bookId", insertable = false, updatable = false)
	private Books books;
	
	@Builder
	public BooksRental(String bookId, Integer rentalSeq, String title, String bookcaseId, String status, String userId,
			LocalDateTime rentalDate, LocalDateTime returnDate, String createUser, String updatedUser, Books books) {
		this.bookId = bookId;
		this.rentalSeq = rentalSeq;
		this.title = title;
		this.bookcaseId = bookcaseId;
		this.status = status;
		this.userId = userId;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
		this.createUser = createUser;
		this.updatedUser = updatedUser;
		this.books = books;
	}
	
	public void returnBook(String userId) {
		this.status = "반납완료";
		this.returnDate = LocalDateTime.now();
		this.updatedUser = userId;
	}
	
}