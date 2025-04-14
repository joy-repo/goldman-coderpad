package com.test;

import java.util.Arrays;
/**
 * Given a row number and an index, return the value at that position in Pascal's
 * triangle.
 *
 * For example, for row 6 and index 3, the output should be 20.
 *
 * The program includes a method to compute Pascal's triangle and a main method to
 * test it.
 */

public class PascalTraingle {

	public static int getNoFromPascle(int row, int index) {
		int[][] pt = computePascle(row);
		Arrays.stream(pt).forEach(a->System.out.println(Arrays.toString(a)));
		return pt[row - 1][index];
	}

	public static int[][] computePascle(int row) {
		int[][] pt = new int[row][row];

		for (int line = 0; line < row; line++) {

			for (int i = 0; i <= line; i++) {
				if (i == 0 || i == line) {
					pt[line][i] = 1;
				} else {
					pt[line][i] = pt[line - 1][i - 1] + pt[line - 1][i];
				}
			}
		}
		return pt;
	}

	public static void main(String[] s) {
		System.out.println(getNoFromPascle(6, 3));
	}

}
