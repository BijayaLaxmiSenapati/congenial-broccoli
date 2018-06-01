/**
 * purpose: checks whether a given arithmatic expression is balanced or not.
 * @author: Bijaya Laxmi Senapati
 * @since:25/05/2018
 * @verion:1.0
 */
package com.bridgelabz.datastructureprograms;

import com.bridgelabz.utility.Utility;

public class BalancedParanthesisUsingStack
{
	static MyStack<Character> mystack=new MyStack<Character>();
	public static void main(String[] args)
	{
		System.out.println("enter a arithmatic expression ");
		String expression=Utility.retNextLine();
		Utility utility=new Utility();
		if(utility.checkForValidExpression(expression,mystack)==true)
		{
			System.out.println("the given expression is valid");
		}
		else
		{
			System.out.println("the given expression is not valid");
		}
		
	}
}
