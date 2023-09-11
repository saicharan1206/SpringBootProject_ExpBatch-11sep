package com.jspiders.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jspiders.project.utility.ErrorStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(UserWithSameEmailExist.class)
	public ResponseEntity<ErrorStructure> emailAlreadyExist(UserWithSameEmailExist ex) {
		
		ErrorStructure errorStructure = new ErrorStructure();
		errorStructure.setMessage(ex.getMessage());
		errorStructure.setRootCause("User email already in database");
		errorStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		
	return new ResponseEntity<ErrorStructure>(errorStructure,HttpStatus.NOT_ACCEPTABLE);
	}
}
