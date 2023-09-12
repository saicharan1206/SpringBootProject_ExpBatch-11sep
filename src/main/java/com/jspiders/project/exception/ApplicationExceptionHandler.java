package com.jspiders.project.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jspiders.project.utility.ErrorStructure;

import jakarta.servlet.http.HttpServletRequest;
@RestControllerAdvice
public class ApplicationExceptionHandler
{
	@ExceptionHandler(UserAlreadyExist.class)
	public ResponseEntity<?> handleUserAlreadyExist(UserAlreadyExist exception,HttpServletRequest request)
	{
		ErrorStructure error=new ErrorStructure();
		error.setMessage(exception.getMessage());
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setRootCause(request.getRequestURI());
		error.setLocalDateTime(LocalDateTime.now());
		
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
}
