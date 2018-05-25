/**
 * 
 */
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utility.Utility;

public class Binary {

	public static void main(String[] args)
	{
		String swapedBinary;
		System.out.println("enter a decimal number");
		int decimal=Utility.retInt();
		String binary=Utility.decimalToBinary(decimal);
		System.out.println("binary="+binary);
		swapedBinary=binary.substring(4, 8)+binary.substring(0,4);
		System.out.println("swapedBinary="+swapedBinary);
		int swapedDecimal=Utility.binaryToDecimal(swapedBinary);
		System.out.println("decimal value after swapping "+decimal+" is "+swapedDecimal);
	}

}
