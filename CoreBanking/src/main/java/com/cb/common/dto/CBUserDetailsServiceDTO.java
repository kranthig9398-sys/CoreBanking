package com.cb.common.dto;

public class CBUserDetailsServiceDTO {

	private Integer userId;
	private String username;
	private String roll;
	private String password;
	private int schemeCode;
	private int loginLevel;
	private String solDate;
	private int solId;

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
	public int getSchemeCode() {
		return schemeCode;
	}
	public void setSchemeCode(int schemeCode) {
		this.schemeCode = schemeCode;
	}
	public int getLoginLevel() {
		return loginLevel;
	}
	public void setLoginLevel(int loginLevel) {
		this.loginLevel = loginLevel;
	}
	public String getSolDate() {
		return solDate;
	}
	public void setSolDate(String solDate) {
		this.solDate = solDate;
	}
	public int getSolId() {
		return solId;
	}
	public void setSolId(int solId) {
		this.solId = solId;
	}
	@Override
	public String toString() {
		return "CBUserDetailsServiceDTO [userId=" + userId + ", username=" + username + ", roll=" + roll + ", password="
				+ password + ", schemeCode=" + schemeCode + ", loginLevel=" + loginLevel + ", solDate=" + solDate
				+ ", solId=" + solId + "]";
	}
}
