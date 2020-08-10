package com.cyoung90.bookcase.domain.bookcase.member;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookcaseMemberRepository extends JpaRepository<BookcaseMember, BookcaseMemberPK> {
	
	List<BookcaseMember> findAllByUserId(String userId);
	
}