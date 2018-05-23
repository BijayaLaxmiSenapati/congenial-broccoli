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
		System.out.println("guess a number between 0 to "+(n-1));
		int low=0;
		int high=n-1;
		search(low,high);
	}

	private static void search(int low, int high)
	{
		int mid=low+(high-low)/2;
		if(low<high)
		{
			System.out.println("Is your number in between "+mid+" and "+high);
			if(Utility.retBoolean())
			{
				search(mid+1,high);
			}
			else
			{
				search(low,mid);
			}
		}
		else
		{
			System.out.println("the number is "+low);
		}
		
	}

}
