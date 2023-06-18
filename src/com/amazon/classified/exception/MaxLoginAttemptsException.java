package com.amazon.classified.exception;

public class MaxLoginAttemptsException extends Exception {

	private static final long serialVersionUID = 1L;

	//exception for users exceeding maximum login attempts
	public MaxLoginAttemptsException(String message) {
		super();	
	}

	
}
