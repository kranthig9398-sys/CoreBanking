package com.cb.common.dto;

public class CBUserDetailsServiceDTO {

	private Integer userId;
	private String username;
	private String roll;
	private String password;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "CBUserDetailsServiceDTO [userId=" + userId + ", username=" + username + ", roll=" + roll + ", password="
				+ password + "]";
	}
	
}
