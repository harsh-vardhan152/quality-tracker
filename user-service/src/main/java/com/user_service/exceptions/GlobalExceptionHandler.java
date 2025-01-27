package com.user_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.user_service.exceptions.playload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	//why we have added this annotons is when we have the exception occur of ResourceNotFound then it will automatically get call so byy that we can able to handle the exception.
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex)
	{
		String message = ex.getMessage();
		
		
		//using constructor to create ApiRespone
		ApiResponse response = new ApiResponse(message,true,HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

}
