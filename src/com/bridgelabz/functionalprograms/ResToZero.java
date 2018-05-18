/**
 * 
 */
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

/**
 * @author adminstrato
 *
 */
public class ResToZero 
{

	
	public static void main(String[] args) 
	{
		System.out.println("enter how many numbers you want to save in the array");
		int n=Utility.retInt();
		int[] arr=new int[n];
		System.out.println("enter the numbers");
		for(int i=0;i<n;i++)
		{
			arr[i]=Utility.retInt();
		}
		Utility.combineToGetZero(arr);
	}

}
