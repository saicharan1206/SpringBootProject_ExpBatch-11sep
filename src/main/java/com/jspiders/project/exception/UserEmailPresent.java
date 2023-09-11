package com.jspiders.project.exception;

public class UserEmailPresent extends RuntimeException {
	private String message;

	public UserEmailPresent(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
