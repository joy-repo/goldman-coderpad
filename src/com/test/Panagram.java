package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given a sentence, find the missing letters from the alphabet.
 *
 * For example, for the input "The quick brown fox jumps over the lazy dog",
 * the output should be an empty string, as it contains all letters of the
 * alphabet.
 *
 * The program includes a method to find the missing letters and a main method
 * to test it.
 */

public class Panagram {

	/*
	 * Pangram FInder
	 *
	 * The sentence "The quick brown fox jumps over the lazy dog" contains every
	 * single letter in the alphabet. Such sentences are called pangrams. Write a
	 * function findMissingLetters, which takes a String `sentence`, and returns all
	 * the letters it is missing
	 *
	 */

	private static class PanagramDetector {
		private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

		public String findMissingLetters(String sentence) {
			
		//	List<Character> lst =.stream().filter(c->!sentence.contains(c+"")).collect(Collectors.toList());
//			lst.remove(index);
//			sentence = sentence.replace("//s", "");
			String res = "";
			for( char c : ALPHABET.toCharArray()) 
				if(!sentence.contains(c+"")) res= res+c;
			
			
			return res;
		}

	}

	public static void main(String[] args) {
		PanagramDetector pd = new PanagramDetector();
		boolean success = true;

		success = success && "".equals(pd.findMissingLetters("The quick brown fox jumps over the lazy dog"));
		success = success && "abcdefghijklmnopqrstuvwxyz".equals(pd.findMissingLetters(""));

		if (success) {
			System.out.println("Pass ");
		} else {
			System.out.println("Failed");
		}
	}
}
