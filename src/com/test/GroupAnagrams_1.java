package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given a string of words, group the anagrams together. An anagram is a word
 * formed by rearranging the letters of a different word, using all the
 * original letters exactly once.
 *
 * For example, "listen" and "silent" are anagrams of each other.
 *
 * The output should be a list of sets, where each set contains the words that
 * are anagrams of each other.
 */

public class GroupAnagrams_1 {

	static String input = "cat dog tac sat tas god dog";

	public static void main(String[] args) {
		sol();
	}

	static String sol() {

		String[] strArr = input.split(" ");

		List<String> strArrCopy = Arrays.stream(strArr).map(GroupAnagrams_1::sortWord).collect(Collectors.toList());

		List<Word> wordList = new ArrayList<>();
		IntStream.range(0, strArrCopy.size()).forEach(i -> {
			wordList.add(new Word(strArrCopy.get(i), i));
		});

		wordList.stream().sorted().forEach(w -> System.out.println(strArr[w.index]));
		
		//wordList.sort((w1,w2)-> w1.str.compareTo(w2.str));

		return "";
	}

	static class Word implements Comparable<Word> {

		String str;
		int index;

		public Word() {
		}

		public Word(String str, int index) {
			this.str = str;
			this.index = index;
		}

		@Override
		public int compareTo(Word o) {

			return this.str.compareTo(o.str);
		}

	}

	private static String sortWord(String s) {
		char[] ar = s.toCharArray();
		Arrays.sort(ar);
		return new String(ar);
	}

}
