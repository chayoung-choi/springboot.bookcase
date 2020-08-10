package com.cyoung90.bookcase.domain.bookcase.member;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.cyoung90.bookcase.domain.BaseTimeEntity;
import com.cyoung90.bookcase.domain.user.Role;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity(name = "TB2_BOOKCASE_MEMBER")
@IdClass(BookcaseMember.class)
public class BookcaseMember extends BaseTimeEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private String bookcaseId;
	
	@Id
	private String userId;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;
	private String useYn;
	private String createUser;
	private String updatedUser;
	
	@Builder
	public BookcaseMember(String bookcaseId, String userId, Role role,
			String useYn, String createUser, String updatedUser) {
		this.bookcaseId = bookcaseId;
		this.userId = userId;
		this.role = role;
		this.useYn = useYn;
		this.createUser = createUser;
		this.updatedUser = updatedUser;
	}
	
	public String getRoleKey() {
		return this.role.getKey();
	}
	
}