package com.jspiders.project.exception;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jspiders.project.utility.ErrorStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> UserFoundByEmail(UserFoundByEmail ex)
	{
		ErrorStructure structure=new ErrorStructure();
		structure.setStatusCode(HttpStatus.FOUND.value());
		structure.setMessage(ex.getMessage());
		structure.setRootCause("User email ID already exist!!");
		return new ResponseEntity<ErrorStructure>(structure,HttpStatus.FOUND);	
	}
}
