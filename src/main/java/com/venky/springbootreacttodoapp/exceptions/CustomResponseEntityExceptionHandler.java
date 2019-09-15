package com.venky.springbootreacttodoapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler
	public final ResponseEntity handleProjectIdException(ProjectIdException ex)
	{
		ProjectIdExceptionResponse entityException = new ProjectIdExceptionResponse(ex.getMessage());
		return new ResponseEntity(entityException, HttpStatus.BAD_REQUEST);
	}
}
