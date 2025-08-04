package com.greengear.auth.Exception;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String errMesg) {
		super(errMesg);
	}
}
