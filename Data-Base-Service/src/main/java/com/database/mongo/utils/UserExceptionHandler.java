package com.database.mongo.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class UserExceptionHandler {
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> UserNotFound(Exception ex,WebRequest request){
		return new ResponseEntity<Object>("User Not Found...",HttpStatus.NOT_FOUND);
	}
}
