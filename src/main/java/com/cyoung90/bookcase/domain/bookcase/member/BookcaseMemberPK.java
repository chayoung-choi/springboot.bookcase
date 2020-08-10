package com.cyoung90.bookcase.domain.bookcase.member;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookcaseMemberPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NonNull
	@Column(nullable = false, updatable = false)
	private String bookcaseId;
	
	@NonNull
	@Column(nullable = false, updatable = false)
	private String userId;
}
