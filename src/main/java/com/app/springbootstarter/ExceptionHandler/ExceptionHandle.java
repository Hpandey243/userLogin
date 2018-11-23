package com.infy.springbootstarter.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ExceptionHandle extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value=NotFoundException.class)
	public ResponseEntity<Object> handleException(NotFoundException ex){
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
		
		
	}
	

	

	
 
}