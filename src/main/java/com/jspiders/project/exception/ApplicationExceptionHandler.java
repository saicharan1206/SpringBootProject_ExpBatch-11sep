package com.jspiders.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jspiders.project.utility.ErrorStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> userEmailAlreadyFound(EmailAlreadyExistException exc){
		ErrorStructure structure = new ErrorStructure();
		structure.setStatusCode(HttpStatus.FOUND.value());
		structure.setMessage(exc.getMessage());
		structure.setRootCause("This Email Aready found!!!");
		return new ResponseEntity<ErrorStructure>(structure,HttpStatus.FOUND);
	}

}
