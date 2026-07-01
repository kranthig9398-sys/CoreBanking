package com.cb.common.dto;

public class CBServiceResponseDTO<T> {
	private int status;
	private String message;
	private String errorCode;
	private String errorMessage;
	private String successMessage;
	private T responseBody;

	public CBServiceResponseDTO() {
		super();
	}

	public CBServiceResponseDTO(String message, int status, String errorCode, String errorMessage, T responseBody) {
		super();
		this.message = message;
		this.status = status;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.responseBody = responseBody;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public T getResponseBody() {
		return responseBody;
	}
	public void setResponseBody(T responseBody) {
		this.responseBody = responseBody;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	
}