package com.jspiders.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jspiders.project.utility.ErrorStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> studentNotFoundByID(EmailAlreadyExists ex){
		ErrorStructure structure = new ErrorStructure();
		
		structure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		structure.setMessage(ex.getMessage());
		structure.setRootCause(ex.getEmail()+" Email already exists " );
		return new ResponseEntity<ErrorStructure> (structure, HttpStatus.NOT_FOUND);
	} 
	

}
