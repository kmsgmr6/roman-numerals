package com.demo.romannumerals.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidInputException.class)
	public Map<String, String> handleInvalidInputException(InvalidInputException ex) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("Error Message", ex.getMessage());
		return errorMap;
	}
}
