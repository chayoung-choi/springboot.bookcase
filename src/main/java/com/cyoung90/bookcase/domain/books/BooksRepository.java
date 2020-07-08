package com.cyoung90.bookcase.domain.books;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BooksRepository extends JpaRepository<Books, Long> {
	@Query("SELECT p From TB2_BOOKS p ORDER BY p.id DESC")
	List<Books> findAllDesc();
}