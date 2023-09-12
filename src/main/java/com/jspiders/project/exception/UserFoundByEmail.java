package com.jspiders.project.exception;

public class UserFoundByEmail extends RuntimeException {
	private String message;

	public UserFoundByEmail(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
