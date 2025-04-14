package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a base and an integer exponent, compute the value of base raised to the
 * power of exponent.
 *
 * For example, for the input base = 2 and exponent = 4, the output should be 16.
 *
 * The program includes a method to compute the power and a main method to test
 * it.
 */

/**
 * Implement power(base,exp) correctly. Assume exp is an integer.
 *
 */

public class Power {

	/*
	 * Given base and integer exponent, compute value of base raised to the power of
	 * exponent. Can you implement a solution faster than O(exp)?
	 */
	public static double power1(double base, int exp) {
		if(base==0) return 0;
	    if(exp==0) return 1;
	    if(exp==1) return base;
	    int positiveExp =  (exp<0) ? exp*-1 : exp;
	    double result= (positiveExp%2==0)? power(base*base,positiveExp/2):base*power(base*base,(positiveExp-1)/2);
	    return exp<0 ? 1/result:result;
	}
	
	
	public static double power(double base, int exp) {
	    
	    if(exp==0) return 1.0;
	    if(base==1) return 1.0;
	    List<Double> baseList = new ArrayList<>();
	      
	    
	    int absExp = Math.abs(exp);
	    
	    while(absExp>1){
	      
	      if(absExp%2==0) {base = base*base; 
	                    absExp=absExp/2;}
	      else {
	        baseList.add(base);
	        base = base*base; 
	        absExp=(absExp-1)/2;
	        
	      } 
	    }
	   // System.out.println(baseList);
	   double res = baseList.stream().reduce(base,(b1,b2)-> b1*b2);
	    if(exp<0) return 1/res;
	    return res;
	    
	    
	    
	  }
	
	 public static double power2(double base, int exp) {

		   if(base==1)
		     return 1;
		    if(exp==1)
		      return base;
		    if(exp==0)
		     return 1;
		    
		    int absExp = Math.abs(exp);
		    double res = 0.0;
		    
		    if(exp%2==0)
		      res= power(base*base,absExp/2);
		    else
		      res= base * power(base*base, (absExp-1)/2);
		    
		    if(exp<0) return 1/res;
		    return res;
		  }

	public static boolean doTestsPass() {
	    double base[] = { 2, 2, 2.3, 0, 5.5, 6.2 };
	    int exponent[] = { 4, -3, 20, 10, 0, 1 };
	    boolean doTestsPass = true;
	    double tolerance = 0.0001;

	    for (int i = 0; i < base.length; ++i) {
	      double actual = power2(base[i], exponent[i]);
	      double expected = Math.pow(base[i], exponent[i]);
	      boolean currentResult = Math.abs(actual - expected) < tolerance;
	      doTestsPass = doTestsPass && currentResult;
	      
	        System.out.println("power(" + base[i] + "," + exponent[i] + "). Actual:" + actual + " Expected:" 
	            + Math.pow(base[i], exponent[i])+ " tolerance:" + Math.abs(actual - expected));
	    }
	    
//	    System.out.println("-------------");
//	    for (int i = 0; i < base.length; ++i) {
//		      double actual = power(base[i], exponent[i]);
//		      double expected = Math.pow(base[i], exponent[i]);
//		      boolean currentResult = Math.abs(actual - expected) < tolerance;
//		      doTestsPass = doTestsPass && currentResult;
//		      
//		        System.out.println("power(" + base[i] + "," + exponent[i] + "). Actual:" + actual + " Expected:"
//		            + Math.pow(base[i], exponent[i])+ " tolerance:" + Math.abs(actual - expected));
//		    }
    return doTestsPass;
	  }

	  public static void main(String[] args) {
	    if (doTestsPass())
	      System.out.println("All Tests Pass");
	    else
	      System.out.println("There are test failures");
		  
		  System.out.println(power(2,10));
	  }
}
