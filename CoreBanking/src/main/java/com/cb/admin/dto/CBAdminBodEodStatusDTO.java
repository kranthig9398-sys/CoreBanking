package com.cb.admin.dto;

import java.util.Date;

public class CBAdminBodEodStatusDTO {
	private String moduleName;
	private String branchName;
	private String branchLevel;

	private String bodStatus;
	private String bodDoneBy;
	private Date bodDoneDate;

	private String eodStatus;
	private String eodDoneBy;
	private Date eodDoneDate;
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchLevel() {
		return branchLevel;
	}
	public void setBranchLevel(String branchLevel) {
		this.branchLevel = branchLevel;
	}
	public String getBodStatus() {
		return bodStatus;
	}
	public void setBodStatus(String bodStatus) {
		this.bodStatus = bodStatus;
	}
	public String getBodDoneBy() {
		return bodDoneBy;
	}
	public void setBodDoneBy(String bodDoneBy) {
		this.bodDoneBy = bodDoneBy;
	}
	public Date getBodDoneDate() {
		return bodDoneDate;
	}
	public void setBodDoneDate(Date bodDoneDate) {
		this.bodDoneDate = bodDoneDate;
	}
	public String getEodStatus() {
		return eodStatus;
	}
	public void setEodStatus(String eodStatus) {
		this.eodStatus = eodStatus;
	}
	public String getEodDoneBy() {
		return eodDoneBy;
	}
	public void setEodDoneBy(String eodDoneBy) {
		this.eodDoneBy = eodDoneBy;
	}
	public Date getEodDoneDate() {
		return eodDoneDate;
	}
	public void setEodDoneDate(Date eodDoneDate) {
		this.eodDoneDate = eodDoneDate;
	}
}
