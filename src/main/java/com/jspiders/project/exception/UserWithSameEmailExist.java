package com.jspiders.project.exception;

public class UserWithSameEmailExist extends RuntimeException {

private	String message;

public UserWithSameEmailExist(String message) {
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
