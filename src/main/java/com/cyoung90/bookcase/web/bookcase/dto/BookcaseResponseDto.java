package com.cyoung90.bookcase.web.bookcase.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.cyoung90.bookcase.domain.bookcase.Bookcase;

import lombok.Getter;

@Getter
public class BookcaseResponseDto {
	private String bookcaseId;
	private String name;
	private String picture;
	private String userId;
	private Integer authenticationKey;
	private String useYn;
	private String createUser;
	
	private LocalDate createDate;
	private String updatedUser;
	private LocalDateTime updatedDate;

	public BookcaseResponseDto(Bookcase entity) {
		this.bookcaseId = entity.getBookcaseId();
		this.name = entity.getName();
		this.picture = entity.getPicture();
		this.userId = entity.getUserId();
		this.authenticationKey = entity.getAuthenticationKey();
		this.useYn = entity.getUseYn();
		this.createUser = entity.getCreateUser();
		this.createDate = LocalDate.from(entity.getCreateDate());
		this.updatedUser = entity.getUpdatedUser();
		this.updatedDate = entity.getUpdatedDate();
	}
}