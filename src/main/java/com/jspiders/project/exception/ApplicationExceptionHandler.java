package com.jspiders.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jspiders.project.utility.ErrorStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(emailIdAlreadyPresentException.class)
	public ResponseEntity<ErrorStructure> emailAlreadyExist(emailIdAlreadyPresentException eap) {
		ErrorStructure errorStructure = new ErrorStructure();
		errorStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		errorStructure.setRootCause("email already present");
		errorStructure.setMessage(eap.getMessage());
		
		return new ResponseEntity<ErrorStructure>(errorStructure,HttpStatus.NOT_ACCEPTABLE);
	}
}
