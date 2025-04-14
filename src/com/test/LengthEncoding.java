package com.test;

/**
 * Given a string, the task is to perform length encoding of the string.
 *
 * For example, if the input string is "xxyyzz", the output should be "x2y2z2".
 *
 * The program includes a method to perform the encoding and a main method to
 * test it.
 */


public class LengthEncoding {

	static String str = "xxyyzz";

	static String sol() {

		String res = "";
		int c = 1;
		while (c <= str.length() - 1) {

			int len = 1;
			while (c <= str.length() - 1 && str.charAt(c - 1) == str.charAt(c)) {
				c++;
				len++;
			}
			res = res + str.charAt(c - 1) + len;
			c++;

		}

		return res;

	}

	public static void main(String[] args) {
		System.out.println(sol());
	}

}
