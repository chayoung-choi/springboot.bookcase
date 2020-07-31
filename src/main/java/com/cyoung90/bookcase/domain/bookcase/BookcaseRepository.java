package com.cyoung90.bookcase.domain.bookcase;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookcaseRepository extends JpaRepository<Bookcase, String> {
	@Query("SELECT p From TB2_BOOKCASE p ORDER BY p.bookcaseId DESC")
	List<Bookcase> findAllDesc();
	
	List<Bookcase> findAllByUserId(String userId);
	
	Bookcase findByUserId(String userId);
	
	Bookcase findByUserIdAndBookcaseId(String userId, String bookcaseId);
}