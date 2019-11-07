package com.webonise.login.exception;

public class NoUniqueUserFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoUniqueUserFoundException(String message) {
		super(message);
	}

	public NoUniqueUserFoundException() {
		super();
	}

}
