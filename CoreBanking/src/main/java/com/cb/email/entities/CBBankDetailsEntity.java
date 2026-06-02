package com.cb.email.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="BANKDETAILS")
public class CBBankDetailsEntity {
	@Id
	@Column(name="BANK_ID")
	private int id;
	@Column(name="BNAME")
	private String bankName;
	@Column(name="BLOCATION")
	private String bankLocation;
	@Column(name="PERENT_SOL")	
	private String bankPSolId;
	@Column(name="NODAL_SOL")
	private String bankNSolId;
	
	
	public CBBankDetailsEntity() {
		super();
	}
	
	public CBBankDetailsEntity(int id, String bankName, String bankLocation, String bankPSolId, String bankNSolId) {
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
