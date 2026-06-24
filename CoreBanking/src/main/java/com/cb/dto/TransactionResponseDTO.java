package com.cb.dto;

public class TransactionResponseDTO {

	    private String grnNumber;

	    private String transactionId;

	    private String customerName;

	    private String accountNumber;

	    private String branchName;

	    private String solId;

	    private String amount;

	    private String status;

	    private String transactionDate;

	    private String remarks;

	    public TransactionResponseDTO() {
	    }

	    public TransactionResponseDTO(
	            String grnNumber,
	            String transactionId,
	            String customerName,
	            String accountNumber,
	            String branchName,
	            String solId,
	            String amount,
	            String status,
	            String transactionDate,
	            String remarks) {

	        this.grnNumber = grnNumber;
	        this.transactionId = transactionId;
	        this.customerName = customerName;
	        this.accountNumber = accountNumber;
	        this.branchName = branchName;
	        this.solId = solId;
	        this.amount = amount;
	        this.status = status;
	        this.transactionDate = transactionDate;
	        this.remarks = remarks;
	    }

	    public String getGrnNumber() {
	        return grnNumber;
	    }

	    public void setGrnNumber(String grnNumber) {
	        this.grnNumber = grnNumber;
	    }

	    public String getTransactionId() {
	        return transactionId;
	    }

	    public void setTransactionId(String transactionId) {
	        this.transactionId = transactionId;
	    }

	    public String getCustomerName() {
	        return customerName;
	    }

	    public void setCustomerName(String customerName) {
	        this.customerName = customerName;
	    }

	    public String getAccountNumber() {
	        return accountNumber;
	    }

	    public void setAccountNumber(String accountNumber) {
	        this.accountNumber = accountNumber;
	    }

	    public String getBranchName() {
	        return branchName;
	    }

	    public void setBranchName(String branchName) {
	        this.branchName = branchName;
	    }

	    public String getSolId() {
	        return solId;
	    }

	    public void setSolId(String solId) {
	        this.solId = solId;
	    }

	    public String getAmount() {
	        return amount;
	    }

	    public void setAmount(String amount) {
	        this.amount = amount;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public String getTransactionDate() {
	        return transactionDate;
	    }

	    public void setTransactionDate(String transactionDate) {
	        this.transactionDate = transactionDate;
	    }

	    public String getRemarks() {
	        return remarks;
	    }

	    public void setRemarks(String remarks) {
	        this.remarks = remarks;
	    }

	    @Override
	    public String toString() {
	        return "TransactionResponseDTO [grnNumber=" + grnNumber
	                + ", transactionId=" + transactionId
	                + ", customerName=" + customerName
	                + ", accountNumber=" + accountNumber
	                + ", branchName=" + branchName
	                + ", solId=" + solId
	                + ", amount=" + amount
	                + ", status=" + status
	                + ", transactionDate=" + transactionDate
	                + ", remarks=" + remarks + "]";
	    }
	}