package com.cb.admin.dto;

public class CBAdminCommonDetailsServiceDTO {

	private String userId;
	private String userName;
	private String roleCode;
	private String levelCode;
	private String schemeCode;
	private String  branchCode;
	private String solsDate;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getLevelCode() {
		return levelCode;
	}
	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}
	public String getSchemeCode() {
		return schemeCode;
	}
	public void setSchemeCode(String schemeCode) {
		this.schemeCode = schemeCode;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getSolsDate() {
		return solsDate;
	}
	public void setSolsDate(String solsDate) {
		this.solsDate = solsDate;
	}
}
