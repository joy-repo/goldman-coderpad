package com.test;

/**
 * Given an array of integers, find the amount of snow that can be stored
 * between the peaks.
 *
 * For example, for the input {0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0}, the output should
 * be 10.
 *
 * The program includes a method to compute the snow pack and a main method to
 * test it.
 */

public class SnowPack {

	static int[] arr = { 0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0 };
	
	
	public static void main(String[] args) {
		System.out.println(sol());
	}

	public static int sol() {

		int[] prevMax = new int[arr.length];
		int[] postMax = new int[arr.length];

		prevMax[0] = arr[0];
		
		for (int i = 1; i < arr.length; i++)
			prevMax[i] = prevMax[i - 1] < arr[i] ? arr[i] : prevMax[i - 1];

		postMax[arr.length - 1] = arr[arr.length - 1];
		
		for (int i = arr.length - 2; i >= 0; i--)
			postMax[i] = postMax[i + 1] < arr[i] ? arr[i] : postMax[i + 1];
			
		int res=0;
			
		for(int i=1; i<arr.length-1;i++) {
			res= res + (Math.min(prevMax[i], postMax[i])>arr[i] ? Math.min(prevMax[i], postMax[i])-arr[i]:0);
		}
		
		return res;

	}

}
