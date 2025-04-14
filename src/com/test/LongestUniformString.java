package com.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the longest substring that consists of the same
 * character.
 *
 * For example, for the input "abbbccda", the longest uniform substring is "bbb"
 * (which starts at index 1 and is 3 characters long).
 *
 * The program includes a method to find the longest uniform substring and a main
 * method to test it.
 */

public class LongestUniformString {

	/**
	 * 
	 * e.g. for the input: "abbbccda" the longest uniform substring is "bbb" (which
	 * starts at index 1 and is 3 characters long).
	 */

	private static final Map<String, int[]> testCases = new HashMap<String, int[]>();
	
	static int[] sol(String s) {
		char[] arr = s.toCharArray();
		
		int start=0;
		int f=0;
		
		for(int i=1; i<s.length();) {
			int len =1;
			int t_start=i-1;
			while(i<s.length() && arr[i-1]==arr[i]) {
				len++;
				i++;
			}
			
			if(len>f) {
				start = t_start;
				f = len;
			}
			i++;
		}
		
		return new int[] {start, f};
		
	}
	
	

	static int[] longestUniformSubstring(String input) {
		int longStart = -1;
		int longLen = 0;
		int strIndex = 1;
		int length = input.length();
		while (strIndex < length) {
			int start = strIndex - 1;
			int currLen = 1;
			while (strIndex < length && input.charAt(strIndex) == input.charAt(strIndex - 1)) {
				strIndex++;
				currLen++;
			}
			if (currLen > longLen) {
				longStart = start;
				longLen = currLen;
			}
			strIndex++;
		}
		return new int[] { longStart, longLen };
	}

	static int[] longestUniformSubstring2(String input) {

		char pre = '.';
		int start = 0;
		int end = 0;
		int t_start = 0;
		int t_end = 0;
		boolean bStart = false;
		int i = -1;

		for (char c : input.toCharArray()) {
			i++;

			if (pre == '.') {
				pre = c;

				continue;
			}

			if (pre == c) {
				if (bStart)
					t_end++;
				else {
					t_end = i;
					t_start = i - 1;
					bStart = true;
				}

			}

			if (pre != c) {
				if (end - start < t_end - t_start) {
					end = t_end;
					start = t_start;

				}
				bStart = false;

			}
			pre = c;

		}
		
		if (end - start < t_end - t_start) {
			end = t_end;
			start = t_start;

		}

		return new int[] { start, end-start+1 };

	}

	public static void main(String[] args) {
		// testCases.put("", new int[] { -1, 0 });
		
		System.out.println(Arrays.toString(sol("null")));
		
		testCases.put("10000111", new int[] { 1, 4 });
		testCases.put("aabbbbbCdAA", new int[] { 2, 5 });
		
		

		boolean pass = true;
		for (Map.Entry<String, int[]> testCase : testCases.entrySet()) {
			int[] result = sol(testCase.getKey());
			pass = pass && (Arrays.equals(result, testCase.getValue()));
		}
		if (pass) {
			System.out.println("Pass!");
		} else {
			System.out.println("Failed! ");
		}
	}

}
