package com.jspiders.project.exception;

public class EmailAlreadyExistsException extends RuntimeException{
	private String message;

	public EmailAlreadyExistsException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
