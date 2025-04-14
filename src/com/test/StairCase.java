package com.test;

/**
 * Given a number of stairs, find the number of ways to climb them.
 *
 * For example, for 4 stairs, the output should be 7.
 *
 * The program includes a method to compute the number of ways to climb the stairs
 * and a main method to test it.
 */

public class StairCase {

	static int N = 4;
	
	public static void main(String[] args) {
		System.out.println(sol(0));
	}

	public static int sol(int num) {

		if (num == N)
			return 1;

		if (num > N)
			return 0;
		
		return sol(num+1)+sol(num+2)+sol(num+3);

	}

}
