package com.jspiders.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jspiders.project.utility.ErrorStructure;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorStructure> saveUser(UserAlreadyExist alreadyExist, HttpServletRequest httpServletRequest){
		ErrorStructure error = new ErrorStructure();
		error.setMessage(alreadyExist.getMessage());
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setRootCause(httpServletRequest.getRequestURI());
		
		
		return new ResponseEntity(error, HttpStatus.NOT_FOUND);
		
	}
}
