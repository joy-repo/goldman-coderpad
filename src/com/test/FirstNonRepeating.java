package com.test;

/**
 * The `FirstNonRepeating` class provides a method to find the first non-repeating character
 * in a given string. It uses an array to count the occurrences of each character.
 *
 * Example:
 * Input: "apple"
 * Output: 'a'
 *
 * Input: "racecars"
 * Output: 'e'
 *
 * Input: "ababdc"
 * Output: 'd'
 */


public class FirstNonRepeating {

	public static char findFirst(String input) {
		// code goes here
		char[] c = new char[256];

		for (int i = 0; i < input.length(); i++)
			c[input.charAt(i)]++;

		int index = -1, i;

		for (i = 0; i < input.length(); i++) {
			if (c[input.charAt(i)] == 1) {
				index = i;
				break;
			}
		}

		return input.charAt(index);
	}

	public static void main(String args[]) {

		String[] inputs = { "apple", "racecars", "ababdc" };
		char[] outputs = { 'a', 'e', 'd' };

		boolean result = true;
		for (int i = 0; i < inputs.length; i++) {
			result = result && findFirst(inputs[i]) == outputs[i];
			if (!result)
				System.out.println("Test failed for: " + inputs[i]);
			else
				System.out.println("Test passed for: " + inputs[i]);
		}
	}

}
