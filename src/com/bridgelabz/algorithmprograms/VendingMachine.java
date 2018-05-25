/**
 * 
 */
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utility.Utility;

public class VendingMachine {

	public static void main(String[] args)
	{
		System.out.println("enter how much amount the user want");
		int requiredAmount=Utility.retInt();
		Utility.giveMinimumChange(requiredAmount);
	}

}
