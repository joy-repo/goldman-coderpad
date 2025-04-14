package com.test;
/**
 *  find the smallest element in a circularly sorted array.
 * A circularly sorted array is an array that is sorted but rotated at some pivot.
 *
 */


public class CircularSortedArrayMinimumSmallest {
	public static int FindMin(int[] arr) {

		int i = sol(arr, 0, arr.length - 1);
		System.out.println(i);
		return i;
	}

	public static int sol(int[] arr, int l, int r) {

		if (l == r)
			return arr[l];

		if (l > r)
			return arr[0];

		int mid = (l + r) / 2;

		if (mid < r && arr[mid] > arr[mid + 1])
			return arr[mid + 1];

		if (mid > l && arr[mid - 1] > arr[mid])
			return arr[mid];

		if (arr[r] > arr[mid])
			return sol(arr, l, mid - 1);
		else
			return sol(arr, mid + 1, r);

	}

	public static void main(String args[]) {
		boolean result = true;
		result = result && FindMin(new int[] { 3, 4, 5, 6, 1, 2 }) == 1;
		result = result && FindMin(new int[] { 2, 1 }) == 1;
		result = result && FindMin(new int[] { 1 }) == 1;

		try {
			FindMin(null);
			result = false;
		} catch (Exception e) {
			result = result && true;
		}

		if (result) {
			System.out.println("All tests pass");
		} else {
			System.out.println("There are test failures");
		}
	}
}