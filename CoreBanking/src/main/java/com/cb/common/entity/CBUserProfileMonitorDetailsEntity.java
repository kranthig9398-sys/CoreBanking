package com.cb.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CB_USER_PROFILE")
public class CBUserProfileMonitorDetailsEntity {
	
	@Column(name = "SOL_ID")
	private String solId;
	@Id
	@Column(name = "USER_ID",nullable = false, unique = true)
	private String userID;
	@Column(name = "SESSION_ID")
	private String sessionId;
	@Column(name = "USER_LOGIN_LVL")
	private String userLoginLevel;
	@Column(name = "IP_ADDRESS")
	private String ipAddress;
	@Column(name = "USER_KEY")
	private String userKey;
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
}
