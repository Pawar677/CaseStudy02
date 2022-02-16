package com.sonata.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)  // To give response when page not found. 
public class ResuorceNotFound extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ResuorceNotFound(String message) {
		
		super (message);
	}

}
