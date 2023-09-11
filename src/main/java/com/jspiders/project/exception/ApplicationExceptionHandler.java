package com.jspiders.project.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jspiders.project.utility.ErrorStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		List<ObjectError> allErrors = ex.getAllErrors();
		Map<String, String> errors = new HashMap<>();

		for(ObjectError error : allErrors) {
			FieldError fieldError = (FieldError)error;
			String field = fieldError.getField();
			String message = fieldError.getDefaultMessage();
			errors.put(field, message);
		}
		return new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> userAlreadyRegistered(UserExistsException exception){
		ErrorStructure es = new ErrorStructure();
		es.setStatusCode(HttpStatus.NOT_FOUND.value());
		es.setMessage(exception.getMessage());
		es.setRootCause("User Already Registered!!!");
		return new ResponseEntity<ErrorStructure>(es, HttpStatus.NOT_FOUND);
	}
}