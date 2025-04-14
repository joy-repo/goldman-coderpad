package com.test;

import java.util.Arrays;

/**
 * Given two sorted arrays, find the median of the combined array.
 *
 * For example, if the input arrays are {1, 3, 5, 7, 8, 13} and {2, 4, 6, 9},
 * the output should be 5.5.
 *
 * The program includes a method to find the median and a main method to test it.
 */

public class Median {
	 
	  
	  public static double sol(int[] a1, int[] a2){
	    
	    int res[] = new int[a1.length+a2.length];
	    
	    
	    
	    for(int i=0,j=0; i<a1.length || j<a2.length;){
	      
	      if(i>=a1.length){
	        res[i+j] = a2[j];
	        j++;
	        continue;
	      }
	      
	      if(j>=a2.length){
	        res[i+j] = a1[i];
	        i++;
	        continue;
	      }
	      
	      res[i+j]= a1[i]>a2[j] ? a2[j]:a1[i];
	      
	      if(a2[j]>a1[i]) i++; else j++;
	    }
	    System.out.println(Arrays.toString(res));
	    
	    
	    
	    return (res.length % 2==0? ((double)res[(res.length/2)-1] + res[(res.length/2)])/2: res[(res.length/2)]);
	    
	  }
	  
	  public static double sol1(int[] a1, int[] a2){
	    
	    
	    int m1=0;
	    int m2=0;
	    
	    //int c1=0;
	    //int c2=0;
	   
	    for(int i =0, j=0; (i+j)<=(a1.length+a2.length)/2;){
	      
	      //System.out.println((i+j)+ "--------" + (a1.length+a2.length)/2);
	      
	      if((i+j)==(a1.length+a2.length)/2)  m2=m1; //System.out.println("m2--"+ m2);}
	      
	      if(i>=a1.length) m1=a2[i++];
	      else if(j>=a2.length) m1 = a1[i++];
	      else
	        m1= a1[i]<a2[j] ? a1[i++]:a2[j++];
	      
	      
	    }
	    
	    //System.out.println(m1);
	    //System.out.println(m2);
	    
	    if((a1.length+a2.length)%2==1) return m1;
	    else return ((float)m1+m2)/2;
	    
	  }
	  
	  
	  
	  
	  public static void main(String[] args) {
	    int[] a1 = {1,3,5,7,8,13};
	    int[] a2 = {2,4,6,9};
	    
	    System.out.println(sol1(a1,a2));
	    
	  }
	}