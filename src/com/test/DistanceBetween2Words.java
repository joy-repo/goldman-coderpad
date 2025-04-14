package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * The `DistanceBetween2Words` class provides a method to find the shortest distance
 * between two words in a given paragraph. The distance is defined as the number of
 * characters between the two words, including spaces and punctuation.
 *
 * Example:
 * Input: "In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements",
 * wordOne: "and", wordTwo: "graphic"
 * Output: 6
 *
 * Input: "Design filler text has been used in typesetting since the 1960s or earlier, when it was popularized by advertisements",
 * wordOne: "transfer", wordTwo: "it"
 * Output: 14
 *
 */

public class DistanceBetween2Words {

	public static double shortestDistance(String paragraph, String wordOne, String wordTwo) {

		//String[] wordsFromParagraph = paragraph.split("[,. ]");
		paragraph= paragraph.toLowerCase();
		wordOne=wordOne.toLowerCase();
		wordTwo=wordTwo.toLowerCase();
		
		List<Integer> l1 =new ArrayList<>();
		List<Integer> l2 =new ArrayList<>();
		int i=paragraph.indexOf(wordOne, 0);
		
		while(i!=-1) {
			l1.add(i);
			i=paragraph.indexOf(wordOne, i+1);
		}
		
		i=paragraph.indexOf(wordTwo, 0);
		
		while(i!=-1) {
			l2.add(i);
			i=paragraph.indexOf(wordTwo, i+1);
		}
		
		int res=Integer.MAX_VALUE;
		
		for(int n : l1) 
			for(int m : l2) 
				res = Math.min(res, Math.abs(m-n));
			
		System.out.println(wordOne + "----"+ wordTwo + "---"+res);

		return res;
	}

	public static boolean pass() {
		return shortestDistance(document, "and", "graphic") == 6d || shortestDistance(document, "transfer", "it") == 14d
				|| shortestDistance(document, "Design", "filler") == 25d;
	}

	public static void main(String[] args) {
		if (pass()) {
			System.out.println("Pass");
		} else {
			System.out.println("Some Fail");
		}
	}

	private static final String document;
	static {
		StringBuffer sb = new StringBuffer();
		sb.append(
				"In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements");
		sb.append(
				" lorem ipsum text has been used in typesetting since the 1960s or earlier, when it was popularized by advertisements");
		sb.append(
				" for Letraset transfer sheets. It was introduced to the Information Age in the mid-1980s by Aldus Corporation, which");

		document = sb.toString();
	}
}
