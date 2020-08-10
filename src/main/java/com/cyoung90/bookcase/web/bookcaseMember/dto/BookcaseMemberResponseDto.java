package com.cyoung90.bookcase.web.bookcaseMember.dto;

import java.time.LocalDate;

import com.cyoung90.bookcase.domain.bookcase.member.BookcaseMember;
import com.cyoung90.bookcase.domain.user.Role;

import lombok.Getter;

@Getter
public class BookcaseMemberResponseDto {
	private String bookcaseId;
	private String userId;
	private Role role;
	private String useYn;
	private String createUser;
	private LocalDate createDate;
	private String updatedUser;
	private LocalDate updatedDate;

	public BookcaseMemberResponseDto(BookcaseMember entity) {
		this.bookcaseId = entity.getBookcaseId();
		this.userId = entity.getUserId();
		this.role = entity.getRole();
		this.useYn = entity.getUseYn();
		this.createUser = entity.getCreateUser();
		this.createDate = LocalDate.from(entity.getCreateDate());
		this.updatedUser = entity.getUpdatedUser();
		this.updatedDate = LocalDate.from(entity.getUpdatedDate());
	}
}