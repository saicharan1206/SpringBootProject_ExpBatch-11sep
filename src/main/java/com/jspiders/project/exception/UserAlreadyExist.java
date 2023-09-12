package com.jspiders.project.exception;

public class UserAlreadyExist extends RuntimeException {

	String message;

	public UserAlreadyExist(String message) {
		super(message);
		this.message = message;
	}
	
}
