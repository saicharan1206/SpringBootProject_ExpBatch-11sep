package com.jspiders.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jspiders.project.utility.ErrorStructure;

@RestControllerAdvice 
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> emailAlreadyPresent(EmailException ex){
		ErrorStructure structure = new  ErrorStructure();
		structure.setStatusCode(HttpStatus.ALREADY_REPORTED.value());
		structure.setMessage(ex.getMessage());
		structure.setRootCause("Email is Already present it will not accept duplicate email");
		return new ResponseEntity<ErrorStructure>(structure, HttpStatus.ALREADY_REPORTED);
		
		
	}

}
