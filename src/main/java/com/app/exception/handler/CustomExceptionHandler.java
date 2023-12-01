package com.app.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.exception.CompanyNotFoundException;
import com.app.payload.response.ErrorMessage;

@RestControllerAdvice
public class CustomExceptionHandler {

	/*
	 * If CompanyNotFoundException is thrown from any RestController then below
	 * method is executed and returns error message with 500 status code. It is like
	 * a reusable catch block code.
	 */
	@ExceptionHandler(CompanyNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleCompanyNotFoundException(CompanyNotFoundException cnfe) {
		return ResponseEntity.internalServerError().body(new ErrorMessage(new Date().toString(), cnfe.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name()));
	}

}
