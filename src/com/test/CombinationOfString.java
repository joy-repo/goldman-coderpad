package com.test;


/**
 * generate combinations and permutations
 * of a given string, with or without repetition, based on a specified length.
 */

public class CombinationOfString {

	static String str = "qwe";
	static int N = 2;

	public static void main(String[] args) {
//		// combination2("", 0);
//		System.out.println("-------------------");
//		// combination("", 0);
//		boolean[] st = new boolean[str.length()];
//		perm_without_repeat("", st);
//		perm_with_repeat("");
		
		//combination("",0);
		
		perm_without_repeat("", new boolean[str.length()]);

	}

	private static void perm_with_repeat(String s) {
		if (s.length() == str.length()) {
			System.out.println(s);
			return;
		}

		for (int i = 0; i < str.length(); i++)
			perm_with_repeat(s + str.charAt(i));

	}

	public static void combination(String s, int i) {
		
		
		if (s.length() == N) {
			System.out.println(s);
			return;
		}
		
		for (int c = i; c < str.length(); c++) 
			combination(s + str.charAt(c), c + 1);
	}

	public static void combination2(String s, int i) {

		if (s.length() == N)
			System.out.println(s);

		if (i == str.length())
			return;

		combination2(s + str.charAt(i), i + 1);
		combination2(s, i + 1);

	}

	public static void perm_without_repeat(String s, boolean[] st) {
		
		if (s.length() == N) {
			System.out.println(s);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			if (!st[i]) {
				st[i] = true;
				perm_without_repeat(s + str.charAt(i), st);
				st[i] = false;
			}
		}
	}

}
