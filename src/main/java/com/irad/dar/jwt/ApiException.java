package com.irad.dar.jwt;

import org.springframework.http.HttpStatus;

public class ApiException extends Exception {

	private static final long serialVersionUID = 1L;
	public HttpStatus code;
	   public ApiExceptionBody body;
	   
	    public ApiException(final HttpStatus code, final ApiExceptionBody body) {
	        this.body = body;
	        this.code = code;
	    }
	
}
