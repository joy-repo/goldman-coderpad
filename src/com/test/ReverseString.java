package com.test;

/**
 * Given a string, reverse it.
 *
 * For example, for the input "aString", the output should be "gnirtSa".
 *
 * The program includes a method to reverse the string and a main method to test
 * it.
 */

public class ReverseString {
	
	
	
	public static void main(String[] args) {
		
		String str = "aString";
		String res = "";
		
		for( char c : str.toCharArray()) {
			res= c+res;
		}
		System.out.println(res);
	}

}
