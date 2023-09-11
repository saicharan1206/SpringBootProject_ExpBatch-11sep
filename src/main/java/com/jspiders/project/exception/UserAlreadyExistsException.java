package com.jspiders.project.exception;

public class UserAlreadyExistsException extends RuntimeException{
	
	private String message;

	public UserAlreadyExistsException(String message) {
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
