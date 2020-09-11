package com.cg.dto;

public class ErrorMessage {
	private String state;
	private String message;
	private String timestamp;
	public ErrorMessage(String state, String message, String timestamp) {
		super();
		this.state = state;
		this.message = message;
		this.timestamp = timestamp;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
