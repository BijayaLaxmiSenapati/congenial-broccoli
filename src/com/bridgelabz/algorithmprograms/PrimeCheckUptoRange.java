/**
 * 
 */
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utility.Utility;

/**
 * @author adminstrato
 *
 */
public class PrimeCheckUptoRange {

	
	public static void main(String[] args) 
	{
		for(int i=0;i<=1000;i++)
		{
			if(Utility.isPrime(i))
			{
				System.out.println(i+"  ");
			}
		}
	}

}
