package com.test;

import java.util.Arrays;

/**
 * Given a string of characters representing movements on a 2D plane, find the
 * final position of the robot.
 *
 * The robot starts at the origin (0, 0) and can move in four directions:
 * 'R' (right), 'L' (left), 'U' (up), and 'D' (down).
 *
 * The program includes a method to compute the final position and a main method
 * to test it.
 */

public class RobotMovement {

	public static Integer[] moveOnCircuit(String inputPath) {
		Integer[] res = { 0, 0 };
		for (char inputPathChar : inputPath.toCharArray()) {
			switch (inputPathChar) {
			case 'R':
				res[0] += 1;
				break;
			case 'L':
				res[0] -= 1;
				break;
			case 'U':
				res[1] += 1;
				break;
			case 'D':
				res[1] -= 1;
				break;
			default:
				break;
			}
		}
		return res;
	}

	public static boolean evaluateEquality(Integer[] firstArray, Integer[] secondArray) {
		return Arrays.equals(firstArray, secondArray);
	}

	public static boolean doTestsPass() {
		boolean checkResult = true;
		{
			String test = "";
			Integer[] result = moveOnCircuit(test);
			checkResult &= evaluateEquality(result, new Integer[] { 0, 0 });
		}

		{
			String test = "L";
			Integer[] result = moveOnCircuit(test);
			checkResult &= evaluateEquality(result, new Integer[] { -1, 0 });
		}

		{
			String test = "UUU";
			Integer[] result = moveOnCircuit(test);
			checkResult &= evaluateEquality(result, new Integer[] { 0, 3 });
		}

		{
			String test = "ULDR";
			Integer[] result = moveOnCircuit(test);
			checkResult &= evaluateEquality(result, new Integer[] { 0, 0 });
		}

		{
			String test = "ULLLDUDUURLRLR";
			Integer[] result = moveOnCircuit(test);
			checkResult &= evaluateEquality(result, new Integer[] { -2, 2 });
		}

		{
			String test = "UP LEFT 2xDOWN DOWN RIGHT RIGHT UP UP";
			Integer[] result = moveOnCircuit(test);
			checkResult &= evaluateEquality(result, new Integer[] { 1, 1 });
		}

		return checkResult;
	}

	public static void main(String[] args) {
		if (doTestsPass()) {
			System.out.println("All tests pass");
		} else {
			System.out.println("There are test failures");
		}
	}
}
