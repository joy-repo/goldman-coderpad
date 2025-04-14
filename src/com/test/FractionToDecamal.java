package com.test;

import java.util.HashMap;

public class FractionToDecamal {

	/**
	 * Return the fraction output in the following way Examples: If after decimal,
	 * repeating numbers are there in the output . eg. 1/3=0.333333333, this should
	 * be represented as 0.(3) 6/11=0.54545454, this should be represented as 0.(54)
	 * fractionRepresentation(1,2)=0.5 fractionRepresentation(1,3)=0.(3)
	 * fractionRepresentation(6,11)=0.(54)
	 */
	
	
	public static String sol(Long numerator, Long denominator) {
		
		if (numerator == 0)
			return "0";
		if (denominator == 0)
			return "";
		
		long n = Math.abs(numerator);
		long d = Math.abs(denominator);
		
		HashMap<Long,Integer> map = new HashMap<>();
		long rem = n;
		
		return "";
		
		
	}

	public static String vulgarToDecimal(Long numerator, Long denominator) {
		if (numerator == 0)
			return "0";
		if (denominator == 0)
			return "";

		String result = "";
		
		

		// is result is negative
		if ((numerator < 0) ^ (denominator < 0)) {
			result += "-";
		}

		// convert int to long
		long num = numerator, den = denominator;
		num = Math.abs(num);
		den = Math.abs(den);

		// quotient
		long res = num / den;
		result += String.valueOf(res);

		// if remainder is 0, return result
		long remainder = (num % den) * 10;
		if (remainder == 0)
			return result;

		// right-hand side of decimal point
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		result += ".";
		while (remainder != 0) {
			// if digits repeat
			if (map.containsKey(remainder)) {
				int beg = map.get(remainder);
				String part1 = result.substring(0, beg);
				String part2 = result.substring(beg, result.length());
				result = part1 + "(" + part2 + ")";
				return result;
			}

			// continue
			map.put(remainder, result.length());
			res = remainder / den;
			result += String.valueOf(res);
			remainder = (remainder % den) * 10;
		}

		return result;
	}

	/**
	 * boolean doTestsPass() Returns true if all tests pass. Otherwise false
	 */
	public static boolean doTestsPass() {
		boolean testsPassed = true;

		testsPassed &= vulgarToDecimal(1l, 56l).equals("0.017(857142)");
		testsPassed &= vulgarToDecimal(1l, 2l).equals("0.5");
		testsPassed &= vulgarToDecimal(1l, 3l).equals("0.(3)");
		testsPassed &= vulgarToDecimal(1l, 30l).equals("0.0(3)");
		testsPassed &= vulgarToDecimal(1l, 75l).equals("0.01(3)");
		testsPassed &= vulgarToDecimal(4l, 7l).equals("0.(571428)");

		if (testsPassed) {
			System.out.println("Tests passes");
		} else {
			System.out.println("Tests failed");
		}
		return testsPassed;
	}

	public static void main(String[] args) {
		doTestsPass();
	}
}
