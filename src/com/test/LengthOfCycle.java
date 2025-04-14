package com.test;

import java.util.HashSet;
import java.util.Set;

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

public class LengthOfCycle {
	
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,4,0,5,4};
		
		Set<Integer> ss = new HashSet<>();
		
		int startIndex = 0;
		int i = startIndex;
		int count=0;
		while(count<=arr.length) {
			count++;
			if(ss.contains(i)) break;
			ss.add(i);
			i=arr[i];
		}
		
		//i= duplicateIndex(arr);
		int dup=i;
		i= arr[i];
		int len =1;
		while(i!=dup) {
			len++;
			i=arr[i];
		}
		System.out.println(len);
		
		//System.out.println(duplicateIndex(arr));
		
	}
	
	public  static int duplicateIndex(int[] arr) {
		
		int count =0;
		int doubleMove=0;
		int singleMove=0;
		
		do {
			count++;
			doubleMove= arr[arr[doubleMove]];
			singleMove=arr[singleMove];
			
		}while(count<=arr.length*4 && doubleMove!=singleMove);
		
		if(count==arr.length*4) return -1;
		return singleMove;
		
	}

}
