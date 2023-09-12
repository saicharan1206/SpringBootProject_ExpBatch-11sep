package com.jspiders.project.exception;

public class EmailAllReadyFoundException extends Exception{
	private String message;

	public EmailAllReadyFoundException(String message) {
		super();
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

}
