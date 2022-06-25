package com.myapp.springdemo.rest;

public class StudnetNotFoundException extends RuntimeException {

	public StudnetNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public StudnetNotFoundException(String message) {
		super(message);
	}

	public StudnetNotFoundException(Throwable cause) {
		super(cause);
	}
	
	
}
