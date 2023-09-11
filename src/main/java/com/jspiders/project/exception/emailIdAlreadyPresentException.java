package com.jspiders.project.exception;

public class emailIdAlreadyPresentException extends RuntimeException {
	private String message;

	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public emailIdAlreadyPresentException(String message) {
		super();
		this.message = message;
	}
}
