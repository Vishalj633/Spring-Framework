package com.myapp.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
	
	// Add exception handling code here
	// Add an Exception handler using @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudnetNotFoundException exp){
		
		// Create a StudentErrorResonse
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exp.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		// return ResponceEntity
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		
	}
	
	// Add another exception handler to catch any exception (catch all)
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exp){
		
		// Create a StudentErrorResonse
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exp.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		// return ResponceEntity
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		
	}
}
