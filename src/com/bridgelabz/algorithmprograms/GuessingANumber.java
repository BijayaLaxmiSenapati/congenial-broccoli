/**
 * purpose: takes a command­line argument N, asks you to think of a number
between 0 and N­1, where N = 2^n, and always guesses the answer with n
questions.
b. I/P ­> the Number N and then recursively ask true/false if the number is between a high and low value
 * @author:Bijaya Laxmi Senapati
 * @since:24/05/2018
 * @version:1.0
 */
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utility.Utility;

public class GuessingANumber
{

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
