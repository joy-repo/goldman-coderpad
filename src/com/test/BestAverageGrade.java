package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The BestAverageGrade class computes the highest average grade from a set of student scores.
 *
 * <p>The input is a 2D array where each element contains a student name and a grade (as a string).
 * The method bestAvgGrade calculates the average grade for each student and returns the maximum average.</p>
 *
 * <p>Example:
 * <pre>
 * String[][] scores = {
 *   {"Rohan", "84"},
 *   {"Sachin", "102"},
 *   {"Ishan", "55"},
 *   {"Sachin", "18"}
 * };
 * // Rohan's average: 84, Sachin's average: 60, Ishan's average: 55
 * // The result is 84.
 * </pre>
 * </p>
 */


public class BestAverageGrade {

	public static double bestAvgGrade(String[][] scores) {

		HashMap<String, ArrayList<Integer>> m = new HashMap<String, ArrayList<Integer>>();

		Arrays.stream(scores).forEach(s -> {
			m.putIfAbsent(s[0], new ArrayList<>());
			m.get(s[0]).add(Integer.parseInt(s[1]));
		});

		return m.entrySet().stream().map(Map.Entry::getValue)
				.map(l -> l.stream().collect(Collectors.averagingInt(i -> i))).max(Double::compare).get();
	}

	public static boolean pass() {
		String[][] s1 = { { "Rohan", "84" }, { "Sachin", "102" }, { "Ishan", "55" }, { "Sachin", "18" } };

		return bestAvgGrade(s1) == 84;
	}

	public static void main(String[] args) {
		if (pass()) {
			System.out.println("Pass");
		} else {
			System.out.println("Some Fail");
		}
	}
}