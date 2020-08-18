package com.cyoung90.bookcase.domain.books.rental;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BooksRentalRepository extends JpaRepository<BooksRental, String> {
	@Query("SELECT NVL(MAX(rentalSeq), 0) + 1 FROM TB2_BOOKS_RENTAL WHERE bookId = :bookId")
	Integer getRentalMaxSeq();

}
