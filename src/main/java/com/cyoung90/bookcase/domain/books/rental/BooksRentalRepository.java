package com.cyoung90.bookcase.domain.books.rental;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BooksRentalRepository extends JpaRepository<BooksRental, String> {
	@Query("SELECT NVL(MAX(rentalSeq), 0) + 1 FROM TB2_BOOKS_RENTAL WHERE bookId = :bookId")
	Integer getRentalMaxSeq(@Param("bookId") String bookId);

	List<BooksRental> findAllByUserIdAndStatus(String userId, String status);
	
	BooksRental findByBookIdAndUserIdAndStatus(String bookId, String userId, String status);
}
