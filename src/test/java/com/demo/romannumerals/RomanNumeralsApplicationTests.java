package com.demo.romannumerals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.romannumerals.controller.ConversionController;
import com.demo.romannumerals.exception.InvalidInputException;

@SpringBootTest
class RomanNumeralsApplicationTests {

	@Autowired
	ConversionController conversionController;

	@Test
	public void testDigitsToRomanNumerals() throws InvalidInputException {
		final String romanNumeral = conversionController.digitsToNumerals("123");
		assertEquals("CXXIII", romanNumeral);
	}

	@Test
	public void testRomanNumeralToDigits() throws InvalidInputException {
		final int digit = conversionController.numeralsToDigits("CXXIII");
		assertEquals(123, digit);
	}

	@Test
	public void testRomanNumNotEqualToDigits() throws InvalidInputException {
		final int digit = conversionController.numeralsToDigits("CXXIII");
		assertNotEquals("123", digit);
	}

	@Test
	public void testDigitsNotEqualToRomanNum() throws InvalidInputException {
		final String romanNumeral = conversionController.digitsToNumerals("3214");
		assertNotEquals("MMMCCXI", romanNumeral);
	}

//	@Test
//	public void testNullCheck() throws InvalidInputException {
//		final String romanNumeral = cc.digitsToNumerals("");
//		assertNul
//	}
}
