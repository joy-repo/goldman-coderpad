package com.test;


/**
 * The Decimal class provides a method to convert a fraction represented by its numerator and denominator
 * into its decimal representation. If the decimal representation has a repeating part, it is enclosed in parentheses.
 *
 * Example:
 * Input: 6, 11
 * Output: "0.(54)"
 *
 * Input: 1, 5
 * Output: "0.2"
 *
 * Input: 1, 3
 * Output: "0.(3)"
 */


public class Decimal {

	public static String fractionRepresentation(int nu, int de) {

		float val = (float) nu / (float) de;
		String vals = String.valueOf(val);
		String beforeDot = vals.substring(0, vals.indexOf("."));
		String afterDot = vals.substring(vals.indexOf(".") + 1, vals.length());

		String repeatEle = afterDot.substring(0, 1);
		int i = 1;
		boolean bRepeated = false;
		while (i < afterDot.length() / 2) {
			String temp = afterDot.substring(repeatEle.length(), 2*repeatEle.length());
			if (temp.equals(repeatEle)) {
				bRepeated = true;
				break;
			}

			repeatEle = repeatEle + afterDot.charAt(i);
			i++;
		}
		if (bRepeated)
			return beforeDot + ".(" + repeatEle + ")";
		else
			return beforeDot + "." + afterDot;

	}
	
	public static void main(String[] args) {
		System.out.println(fractionRepresentation(6,11));
		System.out.println(fractionRepresentation(1,5));
		System.out.println(fractionRepresentation(1,3));
	}

}
