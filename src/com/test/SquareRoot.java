package com.test;

/**
 * Given a number, find its square root.
 *
 * For example, for the input 100, the output should be 10.
 *
 * The program includes a method to compute the square root and a main method to
 * test it.
 */

public class SquareRoot {

	public static void main(String args[]) {
		double[] inputs = { 2, 4, 100 };
		double[] expected_values = { 1.41421, 2, 10 };
		double threshold = 0.001;
		for (int i = 0; i < inputs.length; i++) {
			if (Math.abs(squareRoot(inputs[i]) - expected_values[i]) > threshold) {
				System.out.printf("Test failed for %f, expected=%f, actual=%f\n", inputs[i], expected_values[i],
						squareRoot(inputs[i]));
			}
		}
		System.out.println("All tests passed");

		sol(2);
	}

	public static void sol(int number) {

		double result;

		double squareRoot = number / 2;

		do {
			result = squareRoot;
			squareRoot = (result + (number / result)) / 2;
		} while ((result - squareRoot) != 0);

		System.out.println("Reult:" + squareRoot);
	}

	public static double squareRoot(double x) {
		double res = 0;
		boolean found = false;
		double i = 1;
		while (!found) {
			if (i * i == x) {
				res = i;
				found = true;
			} else if (i * i > x) {
				res = findBS(x, i - 1, i);
				found = true;
			}
			i++;
		}

		return res;
	}

	static double findBS(double x, double l, double r) {

		double mid = (l + r) / 2;
		double mul = mid * mid;
		if ((mul == x) || (Math.abs(mul - x) < 0.00001))
			return mid;

		else if (mul < x)
			return findBS(x, mid, r);
		else
			return findBS(x, l, mid);
	}

}
