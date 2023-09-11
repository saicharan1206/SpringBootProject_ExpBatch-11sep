package com.jspiders.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jspiders.project.utility.ErrorStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> userEmailAlreadyFound(EmailAlreadyFoundException exp){
		ErrorStructure error = new ErrorStructure();
		error.setStatusCode(HttpStatus.FOUND.value());
		error.setMessage(exp.getMessage());
		error.setRootCause("This email is already exists !!");
		
		return new ResponseEntity<ErrorStructure>(error , HttpStatus.FOUND);
	}

}
