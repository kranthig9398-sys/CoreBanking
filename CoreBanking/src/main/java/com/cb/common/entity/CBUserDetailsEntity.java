package com.cb.common.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CB_USER_DETAILS_MASTER")
public class CBUserDetailsEntity {

	@Id
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "USER_NAME")
	private String username;

	@Column(name = "USER_PASSWORD")
	private String password;

	@Column(name = "ROLE_ID")
	private String roll;

	@Column(name = "IS_ACTIVE")
	private String isActive;

	public CBUserDetailsEntity() {
	}
	
	public CBUserDetailsEntity(int userId, String username, String password, String roll, String isActive) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.roll = roll;
		this.isActive = isActive;
	}

	public String getIsActive() {
		return isActive;
	}


	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}

	@Override
	public String toString() {
		return "CBUserDetailsEntity [userId=" + userId + ", username=" + username + ", password=" + password + ", roll="
				+ roll + ", isActive=" + isActive + "]";
	}

}