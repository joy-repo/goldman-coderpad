package com.test;

import java.util.Arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * The `DictionaryLongest` class provides a method to find the longest words that can be formed
 * from a given set of letters using a provided dictionary.
 *
 * Example:
 * Input: "toe", Dictionary: ["to", "toe", "toes", "doe", "dog", "god", "dogs"]
 * Output: ["toe"]
 *
 * Input: "osetdg", Dictionary: ["to", "toe", "toes", "doe", "dog", "god", "dogs"]
 * Output: ["toes", "dogs"]
 */

class Dictionary {

	private String[] entries;

	public Dictionary(String[] entries) {
		this.entries = entries;
	}

	public boolean contains(String word) {
		return Arrays.asList(entries).contains(word);
	}
}

public class DictionaryLongest {

	public static Set<String> longestWord(String letters, Dictionary dict) {

		Set<String> allwords = getPossibleWords(letters);
		Set<String> res = new HashSet<>();

		int len = 0;

		for (String s : allwords) {
			if (s.length() < len)
				continue;
			if (dict.contains(s) && len == s.length()) {
				res.add(s);
				continue;
			}
			if (dict.contains(s) && len < s.length()) {
				res.clear();
				res.add(s);
				len = s.length();
			}
		}

		return res;
	}

	private static Set<String> getPossibleWords(String letters) {
		Set<String> ss = new HashSet<>();
		allPossibleWords(letters.toCharArray(), ss, "", new boolean[letters.length()]);
		//ss.forEach(s -> System.out.println(s));
		return ss;
	}

	private static void allPossibleWords(char[] arr, Set<String> ss, String s, boolean[] barr) {

		ss.add(s);

		if (s.length() == arr.length)
			return;

		for (int i = 0; i < arr.length; i++) {
			if (!barr[i]) {
				barr[i] = true;
				allPossibleWords(arr, ss, s + arr[i], barr);
				barr[i] = false;
			}

		}
	}

	public static boolean doTestsPass() {
		Dictionary dict = new Dictionary(
				new String[] { "to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana" });

		boolean result = new HashSet<String>(Arrays.asList("toe")).equals(longestWord("toe", dict));
		result = result && new HashSet<String>(Arrays.asList("toes", "dogs")).equals(longestWord("osetdg", dict));

		return result;
	}

	/**
	 * Execution entry point.
	 */
	public static void main(String[] args) {
		if (doTestsPass()) {
			System.out.println("All tests pass");
		} else {
			System.err.println("There are test failures");
		}
//		Dictionary dict = new Dictionary(
//				new String[] { "to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana" });
//
//		longestWord("osetdg", dict).forEach(System.out::println);
	}
}