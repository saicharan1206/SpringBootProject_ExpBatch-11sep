package com.jspiders.project.exception;

public class EmailAlreadyFoundException extends RuntimeException {
	
	private String message;
	
	public EmailAlreadyFoundException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
