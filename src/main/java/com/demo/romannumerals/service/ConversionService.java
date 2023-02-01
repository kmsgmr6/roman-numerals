package com.demo.romannumerals.service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.demo.romannumerals.exception.InvalidInputException;

@Service
public class ConversionService {

	/*
	 * Method to convert digits to numerals
	 * @param input
	 * @throws InvalidInputException
	 */
	public String digitsToNumerals(String input) throws InvalidInputException {

		int num = 0;
		try {
			num = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		if (num >= 1 && num <= 4000) {
			int numbers[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
			String code[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < code.length; i++) {
				while (num >= numbers[i]) {
					sb.append(code[i]);
					num -= numbers[i];
				}
			}
			return sb.toString();
		} else {
			throw new InvalidInputException("Please enter a valid input");
		}
	}

	/*
	 * Method to convert numerals to digit
	 * @param input
	 * @throws InvalidInputException
	 */
	
	public int numeralsToDigits(String input) throws InvalidInputException {
		boolean flag = isValidInput(input);
		if (flag) {
			Map<Character, Integer> map = new HashMap<Character, Integer>();
			map.put('I', 1);
			map.put('V', 5);
			map.put('X', 10);
			map.put('L', 50);
			map.put('C', 100);
			map.put('D', 500);
			map.put('M', 1000);

			int result = map.get(input.charAt(input.length() - 1));
			for (int i = input.length() - 2; i >= 0; i--) {
				if (map.get(input.charAt(i)) < map.get(input.charAt(i + 1))) {
					result -= map.get(input.charAt(i));
				} else {
					result += map.get(input.charAt(i));
				}
			}
			return result;
		} else {
			throw new InvalidInputException("Please enter a valid Roman Numeral");
		}
	}

	/*
	 * Method to check if the given inputString is valid or not, if valid, method returns true
	 * @param inputString
	 */
	private boolean isValidInput(String inputString) {

		String regex = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
		Pattern p = Pattern.compile(regex);
		if (inputString == null) {
			return false;
		}
		Matcher m = p.matcher(inputString);
		return m.matches();

	}
}
