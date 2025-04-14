package com.test;

import java.util.Arrays;

/**
 * Given two fractions, calculate their sum and return the result as a new
 * fraction.
 *
 * The fractions are represented as arrays of two integers, where the first
 * integer is the numerator and the second integer is the denominator.
 *
 * For example, the fraction 1/2 would be represented as {1, 2}.
 *
 * The result should be returned as an array of two integers, representing the
 * numerator and denominator of the resulting fraction.
 */

public class FractionSum {
	
	
	static int[] frac1= {7,2};
	static int[] frac2 = {2,3};
	
	
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sol()));
	}
	
	
	static int[] sol(int[] f1, int[] f2) {
		
		int lcm = (f1[1]*f2[1])/gcd(f1[1],f2[1]);
		
		int neu = (lcm/f1[1])*f1[0] + (lcm/f2[1])*f2[0];
		
		return new int[] {neu, lcm};
		
		
	}
	
	
	static int[] sol() {
		
		int lcm = (frac1[1]*frac2[1])/gcd(frac1[1], frac2[1]);
		
		int neum = (lcm/frac1[1])*frac1[0] + (lcm/frac2[1])*frac2[0];
		
		return new int[] {neum, lcm};
		
	}
	
	
	static int gcd(int a , int b) {
		if(a==0) return b;
		
		return gcd(b%a,a);
	}

}
