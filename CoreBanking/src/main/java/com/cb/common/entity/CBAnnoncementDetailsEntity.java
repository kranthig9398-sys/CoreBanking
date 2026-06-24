package com.cb.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CB_SCROLL_ANNOUNCEMENTS")
public class CBAnnoncementDetailsEntity {
	@Id
	private int id;
	@Column(name="MESSAGE")
	private String message;
	@Column(name="IS_ACTIVE")
	private boolean isActive;
	@Column(name="CREATED_DATE")
	private String crDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getCrDate() {
		return crDate;
	}
	public void setCrDate(String crDate) {
		this.crDate = crDate;
	}
	
}
