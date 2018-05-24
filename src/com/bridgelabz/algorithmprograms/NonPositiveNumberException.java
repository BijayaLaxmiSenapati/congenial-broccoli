/**
 * 
 */
package com.bridgelabz.algorithmprograms;

public class NonPositiveNumberException extends Exception 
{
	
	NonPositiveNumberException() 
	{
		super("Entered A Negative Number");
	}
	NonPositiveNumberException(String s)
	{
		super(s);
	}
	
}
