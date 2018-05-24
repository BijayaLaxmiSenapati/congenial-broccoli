/**
 * 
 */
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utility.Utility;

public class MonthlyPayment {

	public static void main(String[] args) 
	{
		int principal=Integer.parseInt(args[0]);
		int numberOfYears=Integer.parseInt(args[1]);
		int rateOfIntrest=Integer.parseInt(args[2]);
		double payment=Utility.monthlyPayment(principal,numberOfYears,rateOfIntrest);
		System.out.println("monthly payment of "+payment+" you would have to make over "+numberOfYears+
				" years to pay off a "+principal+" loan amount at "+rateOfIntrest+" percent intrest compounded monthly");
	}

}
