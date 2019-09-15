package com.venky.springbootreacttodoapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.Map;
import java.util.stream.Collectors;


public class AbstractController
{
	protected ResponseEntity<?> mapValidError(BindingResult result)
	{
		Map<String, String> errorMessages = convertErrorMessages(result);
		return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
	}

	protected Map<String, String> convertErrorMessages(BindingResult result)
	{
		return result.getFieldErrors().stream()
				.collect(Collectors.toMap(FieldError::getField, ObjectError::getDefaultMessage, (existed, replace) -> existed));
	}
}
