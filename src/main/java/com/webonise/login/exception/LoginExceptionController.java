package com.webonise.login.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class LoginExceptionController {
	@ExceptionHandler(value = NullPointerException.class)
	   public ResponseEntity<Object> exception(NullPointerException exception) {
	      return new ResponseEntity<>("Login id already exists!", HttpStatus.BAD_REQUEST);
	   }
}
