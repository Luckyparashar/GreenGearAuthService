package com.greengear.auth.Exception;

@SuppressWarnings("serial")
public class InvalidInputException extends RuntimeException {
	public InvalidInputException(String mesg) {
		super(mesg);
	}
}
