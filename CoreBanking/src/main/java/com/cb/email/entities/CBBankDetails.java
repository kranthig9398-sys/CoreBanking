package com.cb.email.entities;

public class CBBankDetails {
	
	private int id;
	private String bankName;
	private String bankLocation;
	private String bankPSolId;
	private String bankNSolId;
	
	
	public CBBankDetails() {
		super();
	}
	
	public CBBankDetails(int id, String bankName, String bankLocation, String bankPSolId, String bankNSolId) {
		super();
		this.id = id;
		this.bankName = bankName;
		this.bankLocation = bankLocation;
		this.bankPSolId = bankPSolId;
		this.bankNSolId = bankNSolId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankLocation() {
		return bankLocation;
	}
	public void setBankLocation(String bankLocation) {
		this.bankLocation = bankLocation;
	}
	public String getBankPSolId() {
		return bankPSolId;
	}
	public void setBankPSolId(String bankPSolId) {
		this.bankPSolId = bankPSolId;
	}
	public String getBankNSolId() {
		return bankNSolId;
	}
	public void setBankNSolId(String bankNSolId) {
		this.bankNSolId = bankNSolId;
	}
}
