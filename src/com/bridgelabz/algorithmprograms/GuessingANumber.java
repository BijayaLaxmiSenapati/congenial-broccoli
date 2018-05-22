/**
 * 
 */
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utility.Utility;

/**
 * @author adminstrato
 *
 */
public class GuessingANumber
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		int n=Integer.parseInt(args[0]);
		System.out.println("guess a number between 0 to "+n);
		int low=0;
		int high=n-1;
		search(low,high);
	}

	private static int search(int low, int high)
	{
		if(high-low==1)
		{
			return low;
		}
		int mid=low+(high-low)/2;
		System.out.println("is your number greater than "+mid);
		if(Utility.retBoolean())
		{
			return search(mid,high);
		}
		else
		{
			return search(low,mid);
		}
	}

}
