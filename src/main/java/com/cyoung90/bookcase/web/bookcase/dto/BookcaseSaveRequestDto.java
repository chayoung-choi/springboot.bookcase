package com.cyoung90.bookcase.web.bookcase.dto;

import com.cyoung90.bookcase.domain.bookcase.Bookcase;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookcaseSaveRequestDto {

	private String name;
	private String picture;
	private String userId;
	private String sessionId;
	private String useYn = "Y";

	@Builder
	public BookcaseSaveRequestDto(String name, String picture) {
		this.name = name;
		this.picture = picture;
	}

	public Bookcase toEntity() {
		return Bookcase.builder().name(name).picture(picture).userId(sessionId).useYn(useYn).authenticationKey(123456)
				.createUser(sessionId).updatedUser(sessionId).build();
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
