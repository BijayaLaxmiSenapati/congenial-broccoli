/**
 * ..
 */
package com.bridgelabz.datastructureprograms;

import com.bridgelabz.utility.Utility;

public class BalancedParanthesisUsingStack
{
	MyStack<Character> mystack=new MyStack<Character>();
	public static void main(String[] args)
	{
		System.out.println("enter a arithmatic expression ");
		String expression=Utility.retNextLine();
		BalancedParanthesisUsingStack object=new BalancedParanthesisUsingStack();
		if(object.checkForValidExpression(expression)==true)
		{
			System.out.println("the given expression is valid");
		}
		else
		{
			System.out.println("the given expression is not valid");
		}
		
	}

	private boolean checkForValidExpression(String expression) 
	{
		char paranthesis;
		for(int i=0;i<expression.length();i++)
		{
			paranthesis=expression.charAt(i);
			if(paranthesis=='(' || paranthesis=='{' || paranthesis=='[')
			{
				mystack.push(paranthesis);
			}
			else
			{
				if(mystack.isEmpty())//({})]
				{
					return false;
				}
				else
				{
					switch (paranthesis)
					{
					case ')':
						if(mystack.peek().equals('('))
						{
							mystack.pop();
						}
						else
						{
							return false;
						}
						break;
					case '}':
						if(mystack.peek().equals('{'))
						{
							mystack.pop();
						}
						else
						{
							return false;
						}
						break;
					case ']':
						if(mystack.peek().equals('['))
						{
							mystack.pop();
						}
						else
						{
							return false;
						}
						break;
					}
				}
			
			}
		
		}
		return true;
	
	}
}
