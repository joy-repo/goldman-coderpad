package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

// calculate the highest average grade among students based on their scores. It processes a 2D array of strings, where each sub-array contains a student's name and their score as a string.

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