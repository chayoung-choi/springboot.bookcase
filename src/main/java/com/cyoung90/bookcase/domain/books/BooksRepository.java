package com.cyoung90.bookcase.domain.books;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BooksRepository extends JpaRepository<Books, String> {
	@Query("SELECT p From TB2_BOOKS p ORDER BY p.id DESC")
	List<Books> findAllDesc();
	
	@Query("SELECT p From TB2_BOOKS p WHERE p.bookcaseId = :bookcaseId ORDER BY p.id DESC")
	List<Books> findAllByBookcaseIdDesc(@Param("bookcaseId") String bookcaseId);
}