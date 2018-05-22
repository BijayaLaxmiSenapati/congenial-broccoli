/**
 * 
 */
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;


public class PermutationOfString 
{
	public static void main(String[] args)
	{
		System.out.println("Enter the string: ");
		String inputString = Utility.retNext();
		permutation(inputString);
	}

	private static void permutation(String inputString) 
	{
		String permute="";
		permuteString(permute,inputString);
       
	}

	private static void permuteString(String permute, String inputString) 
	{
		if (inputString.length() == 0) 
		{
			System.out.println(permute);
		} 
		else 
		{
			for (int i = 0; i < inputString.length(); i++) 
			{
				permuteString(permute + inputString.charAt(i),inputString.substring(0, i) + inputString.substring(i + 1, inputString.length()));
			}
        }
    }
}


