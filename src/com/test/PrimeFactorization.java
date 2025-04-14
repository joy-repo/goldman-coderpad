package com.test;

import java.util.ArrayList;

/**
 * Given an integer, find its prime factorization.
 *
 * For example, for the input 111, the output should be [3, 37].
 *
 * The program includes a method to compute the prime factorization and a main
 * method to test it.
 */

public class PrimeFactorization {
	
	
	
	public static void main(String[] args) {
		
		System.out.println(primeFactorization(111));
		
	}
	
	
	
	 public static ArrayList<Integer> primeFactorization(int input)
	    {
	        ArrayList<Integer> primeFactors = new ArrayList<Integer>();
	        if( input < 2 )
	            return primeFactors;
	        for(int i = 2; i <= input; i++)
	        {
	            while( input % i == 0 )
	            {
	                input = input / i;
	                primeFactors.add(i);
	            }
	        }
	        return primeFactors;
	    }

}
