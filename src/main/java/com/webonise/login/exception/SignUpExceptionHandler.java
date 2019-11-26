package com.webonise.login.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SignUpExceptionHandler {

	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<Object> handlerNullPointerException(RuntimeException exception) {
		return new ResponseEntity<Object>("User already Exist!", HttpStatus.BAD_REQUEST);
	}
}
