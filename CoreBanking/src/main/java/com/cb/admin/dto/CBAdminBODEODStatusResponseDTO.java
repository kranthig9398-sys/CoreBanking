package com.cb.admin.dto;

public class CBAdminBODEODStatusResponseDTO {
	private boolean isBodDone;
	private boolean isEodDone;
	private String message;
	private String bodStatus;
	private String eodStatus;
	
	public boolean isBodDone() {
		return isBodDone;
	}
	public void setBodDone(boolean isBodDone) {
		this.isBodDone = isBodDone;
	}
	public boolean isEodDone() {
		return isEodDone;
	}
	public void setEodDone(boolean isEodDone) {
		this.isEodDone = isEodDone;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getBodStatus() {
		return bodStatus;
	}
	public void setBodStatus(String bodStatus) {
		this.bodStatus = bodStatus;
	}
	public String getEodStatus() {
		return eodStatus;
	}
	public void setEodStatus(String eodStatus) {
		this.eodStatus = eodStatus;
	}

}
