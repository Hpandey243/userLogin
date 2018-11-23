package com.infy.springbootstarter.ExceptionHandler;

@SuppressWarnings("serial")
public class NotFoundException extends Exception
{

	private String message;

	public NotFoundException(String message) {
		
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
