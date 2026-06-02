package com.cb.dto;

public class CBServiceResponseDTO<T> {

	private int Status;
	private String Message;
	private T ResponseBody;
	
	public CBServiceResponseDTO(int status, String message, T responseBody) {
		super();
		Status = status;
		Message = message;
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
	public T getResponseBody() {
		return ResponseBody;
	}
	public void setResponseBody(T responseBody) {
		ResponseBody = responseBody;
	}
}
