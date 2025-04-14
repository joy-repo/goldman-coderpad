package com.test;

import java.util.Arrays;

/**
 * Given an array of integers, where each integer represents the index of the next
 * element in the array, find the length of the cycle in the array.
 *
 * For example, if the input array is {1, 2, 4, 0, 5, 4}, the output should be 3,
 * as the cycle is formed by the elements at indices 4, 5, and 2.
 *
 * The program includes a method to find the length of the cycle and a main
 * method to test it.
 */

public class LengthOfCycle1 {

	/**
	 *
	 * You have an integer array. Starting from arr[startIndex], follow each element
	 * to the index it points to. Continue to do this until you find a cycle. Return
	 * the length of the cycle. If no cycle is found return -1
	 *
	 */
	public static int countLengthOfCycle(int[] arr, int startIndex) {
		// your code goes here
		int[] aux = new int[arr.length];
		Arrays.fill(aux, -1);
		int c = 0;
		while (aux[startIndex] == -1) {
			aux[startIndex] = 1;
			startIndex = arr[startIndex];
			if(startIndex>=arr.length) return -1;
			c++;
		}

		return c;
	}

	public static void main(String[] args) {

		boolean testsPassed = true;

		testsPassed &= countLengthOfCycle(new int[] { 1, 0 }, 0) == 2;
		testsPassed &= countLengthOfCycle(new int[] { 1, 2, 0 }, 0) == 3;
		
		//1 2 4 0 5 4

		if (testsPassed) {
			System.out.println("Test passed.");
			// return true;
		} else {
			System.out.println("Test failed.");
			// return false;
		}

	}

}
