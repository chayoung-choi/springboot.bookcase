package com.cyoung90.bookcase.domain.books.rental;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BooksRentalRepository extends JpaRepository<BooksRental, String> {
	@Query("SELECT NVL(MAX(rentalSeq), 0) + 1 FROM TB2_BOOKS_RENTAL WHERE bookId = :bookId")
	Integer getRentalMaxSeq(@Param("bookId") String bookId);

//	@Query("SELECT p From TB2_BOOKS_RENTAL p WHERE p.bookcaseId = :bookcaseId ORDER BY p.updatedDate DESC")
	List<BooksRental> findAllByUserId(String userId);
}
