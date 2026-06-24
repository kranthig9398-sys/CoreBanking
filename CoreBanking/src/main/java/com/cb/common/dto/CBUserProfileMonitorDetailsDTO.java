package com.cb.common.dto;

public class CBUserProfileMonitorDetailsDTO {
	private String solId;
	private String userID;
	private String sessionId;
	private String userLoginLevel;
	private String ipAddress;
	private String userKey;
	private String action;
	
	public String getSolId() {
		return solId;
	}
	public void setSolId(String solId) {
		this.solId = solId;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getUserLoginLevel() {
		return userLoginLevel;
	}
	public void setUserLoginLevel(String userLoginLevel) {
		this.userLoginLevel = userLoginLevel;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	@Override
	public String toString() {
		return "CBUserProfileMonitorDetailsDTO [solId=" + solId + ", userID=" + userID + ", sessionId=" + sessionId
				+ ", userLoginLevel=" + userLoginLevel + ", ipAddress=" + ipAddress + ", userKey=" + userKey
				+ ", action=" + action + "]";
	}
	
}
