package com.test;

public class Atoi {
	/*
	 * Atoi class is a utility class that provides a method to convert a string
	 * representation of an integer into its corresponding integer value.
	 *
	 * The class contains a static method called atoi that takes a string as input
	 * and returns the integer value represented by that string. The method handles
	 * both positive and negative integers, as well as invalid input cases.
	 *
	 * The doTestsPass method is used to test the functionality of the atoi method
	 * with various test cases.
	 */



	
	
	public static boolean doTestsPass() {
	boolean result = true;
		result = result && atoi("0") == 0;
		result = result && atoi("1") == 1;
		result = result && atoi("123") == 123;
		result = result && atoi("-1") == -1;
		result = result && atoi("-123") == -123;
		result = result && atoi("123a") == 123;
		result = result && atoi("a") == 0;

		String intMax = String.valueOf(Integer.MAX_VALUE);
		result = result && atoi(intMax) == Integer.MAX_VALUE;

		String intMin = String.valueOf(Integer.MIN_VALUE);
		Integer.parseInt(intMin);
		result = result && atoi(intMin) == Integer.MIN_VALUE;
		//System.out.println(atoi("123"));
		return result;
	};

	private static int atoi(String s) {
		
		String str ="";
		
		for(char ss : s.toCharArray()) {
			//System.out.println("ss--"+ss);
			if(ss>='0' && ss<='9') str=str+ss;
		}
		//System.out.println("str---"+str);
		if(str.equals("")) return 0;
		return s.charAt(0)=='-' ? Integer.parseInt("-"+str): Integer.parseInt(str);
		
	}

	public static void main(String[] args) {
		if (doTestsPass()) {
			System.out.println("All tests pass");
		} else {
			System.out.println("There are test failures");
		}
	}

}
