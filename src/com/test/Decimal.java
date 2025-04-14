package com.test;




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
