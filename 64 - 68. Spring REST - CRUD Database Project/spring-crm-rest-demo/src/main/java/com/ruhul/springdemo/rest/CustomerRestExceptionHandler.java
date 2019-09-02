package com.ruhul.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	// Add an exception handler for CustomerNotFoundException
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponce> handleException(CustomerNotFoundException exc) {

		// create CustomerErrorResponce
		CustomerErrorResponce error = new CustomerErrorResponce(
				HttpStatus.NOT_FOUND.value(), 
				exc.getMessage(),
				System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// Add another exception handler .. to catch any exception (catch all)
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponce> handleException(Exception exc) {

		// create CustomerErrorResponce
		CustomerErrorResponce error = new CustomerErrorResponce(
				HttpStatus.BAD_REQUEST.value(), 
				exc.getMessage(),
				System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
