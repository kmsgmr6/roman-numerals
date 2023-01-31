package com.demo.romannumerals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.romannumerals.exception.InvalidInputException;
import com.demo.romannumerals.service.ConversionService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class ConversionController {

	@Autowired
	ConversionService conversionService;

	
	@GetMapping("/roman-numerals/{input}")
	@ApiOperation(value = "Takes numbers from 1 to 4000 as input and converts to valid Roman Numerals")
	public String digitsToNumerals(
			@ApiParam(value = "String value for the number which need to convert to Numeral", required = true) 
			@PathVariable String input)
			throws InvalidInputException {
		return conversionService.digitsToNumerals(input);
	}

	@GetMapping("/digits/{input}")
	@ApiOperation(value = "Takes valid Roman Numerals as input and converts to numbers")
	public int numeralsToDigits(
			@ApiParam(value = "String value for the RomanNumeral which need to convert to Number", required = true) 
			@PathVariable String input)
			throws InvalidInputException {
		return conversionService.numeralsToDigits(input.toUpperCase());
	}

	@GetMapping("/roman-numerals")
	public String digitToNumeral() {
		return "Please enter any valid number input from 1 to 3999 after /roman-numerals/";
	}

	@GetMapping("/digits")
	public String numeralToDigit() {
		return "Please enter any valid Roman numeral input in the URL after /digits/";
	}

}
