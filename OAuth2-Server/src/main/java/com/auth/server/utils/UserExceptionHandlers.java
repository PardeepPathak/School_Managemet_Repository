package com.auth.server.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
public class UserExceptionHandlers {
	@ExceptionHandler(UserNotFoundExcept.class)
	public ResponseEntity<Object> UserNotFoundExcept(Exception ex,WebRequest request){
		return new ResponseEntity<Object>("Status Code:'401'\n"
				+ "Invalid UserName Password \n"
				+ "please try with correct UserName Password",HttpStatus.UNAUTHORIZED);}
		
		@ExceptionHandler(InvalidTokenException.class)
		public ResponseEntity<Object> InvalidTokenException(Exception ex,WebRequest request){
			return new ResponseEntity<Object>("Status Code:'401'\n"
					+ "Invalid Token \n"
					+ "please try with correct Token value",HttpStatus.UNAUTHORIZED);
			}
			
			@ExceptionHandler(ResourceNotFoundException.class)
			public ResponseEntity<Object> ResourceNotFoundException(Exception ex,WebRequest request){
				return new ResponseEntity<Object>("Status Code:'401'\n"
						+ "User Does Not Exist with this id",HttpStatus.UNAUTHORIZED);

}
}