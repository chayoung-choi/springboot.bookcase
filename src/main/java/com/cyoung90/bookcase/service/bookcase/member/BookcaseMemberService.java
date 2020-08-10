package com.cyoung90.bookcase.service.bookcase.member;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyoung90.bookcase.domain.bookcase.member.BookcaseMemberRepository;
import com.cyoung90.bookcase.web.bookcaseMember.dto.BookcaseMemberResponseDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookcaseMemberService {

	private final BookcaseMemberRepository bookcaseMemberRepository;

	@Transactional(readOnly = true) // 조회 기능일 때 조회속도 개선
	public List<BookcaseMemberResponseDto> findAllByUserId(String userId) {
		return bookcaseMemberRepository.findAllByUserId(userId).stream()
				.map(BookcaseMemberResponseDto::new).collect(Collectors.toList());
	}
}
