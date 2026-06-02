package com.cb.dto;

public class CBServiceResponseDTO<T> {

	private int Status;
	private String Message;
	private String ErrorMessage;
	private T ResponseBody;

	public CBServiceResponseDTO(int status, String message, String errorMessage, T responseBody) {
		super();
		Status = status;
		Message = message;
		ErrorMessage = errorMessage;
		ResponseBody = responseBody;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getErrorMessage() {
		return ErrorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}
	public T getResponseBody() {
		return ResponseBody;
	}
	public void setResponseBody(T responseBody) {
		ResponseBody = responseBody;
	}
}
