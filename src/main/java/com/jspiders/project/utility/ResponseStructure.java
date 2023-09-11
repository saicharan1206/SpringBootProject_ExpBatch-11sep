package com.jspiders.project.utility;

public class ResponseStructure<A> {
	private int statusCode;
	private String message;
	private A data;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public A getData() {
		return data;
	}

	public void setData(A data) {
		this.data = data;
	}
}
