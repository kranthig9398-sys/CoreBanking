package com.cb.dto;

public class UserDetailsServiceDTO {

    private String username;
    private String userId;
    private String password;
    private String roll;
    
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
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
		return "UserDetailsServiceDTO [username=" + username + ", userId=" + userId + ", password=" + password
				+ ", roll=" + roll + "]";
	}
	
	
	 
}
