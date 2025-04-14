package com.test;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Collections;

/**
 * The `GroupAnagrams` class provides a method to group words that are anagrams of each other.
 *
 * Example:
 * Input: "abc bac cat dog tac god mcs"
 * Output: [["abc", "bac"], ["cat", "tac"], ["dog", "god"]]
 *


 * Given a string of words, group the anagrams together. An anagram is a word
 * formed by rearranging the letters of a different word, using all the
 * original letters exactly once.
 *
 * For example, "listen" and "silent" are anagrams of each other.
 *
 * The output should be a list of sets, where each set contains the words that
 * are anagrams of each other.
 */

public class GroupAnagrams {
	static String canonicalize(String s) {
		return Stream.of(s.split("")).sorted().collect(Collectors.joining());
	}

	static List<Set<String>> getGroupAnagrams(Reader reader) {
		try (BufferedReader br = new BufferedReader(reader)) {
			Map<String, Set<String>> map = br.lines()
					.flatMap(Pattern.compile("\\W+")::splitAsStream)
					.collect(Collectors.groupingBy(GroupAnagrams::canonicalize, Collectors.toSet()));

			return map.values().stream().filter(list -> list.size() > 1).collect(Collectors.toList());
		} catch( Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	static String sort(String ss) {

		return Stream.of(ss.split("")).sorted().collect(Collectors.joining());

	}

	static List<Set<String>> getGroupAnagrams1(String str){
	    
	    String[] arr = str.split("\\s"); 
	    
	    Map<String, Set<String>> res = Arrays.stream(arr).collect(Collectors.groupingBy(GroupAnagrams::sort,Collectors.toSet()));
	    
	    return res.values().stream().collect(Collectors.toList());
	  }

	public static void main(String[] args) {
		getGroupAnagrams(new StringReader("abc bac cat dog tac god mcs")).forEach(System.out::println);
		System.out.println("---------------");
		getGroupAnagrams1("abc bac cat dog tac god mcs").forEach(System.out::println);
	}
}