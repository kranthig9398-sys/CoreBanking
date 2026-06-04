package com.cb.dto;

public class AuthRequestDTO {

    private String username;
    private String password;
    private String roll;
    
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
		return "AuthRequestDTO [username=" + username + ", password=" + password + ", roll=" + roll + "]";
	}
	 
}
