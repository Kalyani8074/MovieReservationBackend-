
package com.movie.controller;
 
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.movie.excpetion.UserEmailIdExistsException;
import com.movie.excpetion.UserNotFoundException;
 
@ControllerAdvice

public class ExceptionController {

	@ExceptionHandler(value=UserNotFoundException.class)

	public ResponseEntity<Object> exceptionMethod(Exception ex){
		System.out.println("Error Controller called");

		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);

	}
 
	@ExceptionHandler(value=BadCredentialsException.class)

	public ResponseEntity<Object> exceptionMethodBadCreditionals(Exception ex){

		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.FORBIDDEN);

		
		
	}
	
	@ExceptionHandler(value=UserEmailIdExistsException.class)

	public ResponseEntity<Object> exceptionMethodEmailIdExist(Exception ex){

		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.CONFLICT);

	}

	
}
