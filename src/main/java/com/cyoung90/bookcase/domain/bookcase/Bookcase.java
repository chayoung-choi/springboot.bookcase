package com.cyoung90.bookcase.domain.bookcase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.cyoung90.bookcase.domain.BaseTimeEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity(name = "TB2_BOOKCASE")
public class Bookcase extends BaseTimeEntity {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String bookcaseId;
	private String name;
	private String picture;
	private String userId;
	private Integer authenticationKey;
	private String useYn;
	private String createUser;
	private String updatedUser;
	
	@Builder
	public Bookcase(String bookcaseId, String name, String picture, String userId, Integer authenticationKey,
			String useYn, String createUser, String updatedUser) {
		this.bookcaseId = bookcaseId;
		this.name = name;
		this.picture = picture;
		this.userId = userId;
		this.authenticationKey = authenticationKey;
		this.useYn = useYn;
		this.createUser = createUser;
		this.updatedUser = updatedUser;
	}

	@Override
	public String toString() {
		return "Bookcase [bookcaseId=" + bookcaseId + ", name=" + name + ", picture=" + picture + ", userId=" + userId
				+ ", authenticationKey=" + authenticationKey + ", useYn=" + useYn + ", createUser=" + createUser
				+ ", updatedUser=" + updatedUser + "]";
	}
}