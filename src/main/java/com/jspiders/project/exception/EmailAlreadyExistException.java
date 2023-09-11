package com.jspiders.project.exception;

public class EmailAlreadyExistException extends RuntimeException {
	
	private String message;
	public EmailAlreadyExistException(String message) {
		this.message=message;
	}
	
	public String getMessage() {
		return message;
	}

}
