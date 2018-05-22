/**
 * 
 */
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utility.Utility;

public class PallindromePrimeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		for(int i=0;i<=1000;i++)
		{
			if(Utility.isPrime(i))
			{
				if(Utility.isPallindrome(i))
				{
					System.out.println(i+"  ");
				}
			}
		}

	}

}
