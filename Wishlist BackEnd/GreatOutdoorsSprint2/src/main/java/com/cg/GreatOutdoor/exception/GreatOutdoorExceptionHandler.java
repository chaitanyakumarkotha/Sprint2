package com.cg.GreatOutdoor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GreatOutdoorExceptionHandler {
	@ExceptionHandler({ProductException.class,UserException.class,AddressException.class})
	public  ResponseEntity<Object> handle(Exception e)
	{
		return new ResponseEntity<Object>(e.getLocalizedMessage(),HttpStatus.FORBIDDEN);
		
	}
	

}
