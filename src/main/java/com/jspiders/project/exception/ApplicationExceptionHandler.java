package com.jspiders.project.exception;

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
  public ResponseEntity<?> handleUserIdalreadyExist(UserAlreadyExist exception,HttpServletRequest request)
	{
	  ErrorStructure structure=new ErrorStructure();
	  structure.setStatusCode(HttpStatus.NOT_FOUND.value());
	  structure.setMessage(exception.getMessage());
	  structure.setRootCause(request.getRequestURI());
	  return new ResponseEntity<>(structure,HttpStatus.NOT_FOUND);
	}
}
