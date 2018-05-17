package com.bridgelabz.utility;

import java.util.Scanner;

public class Utility 
{
	static Scanner scr=new Scanner(System.in);
	
	/*
	 * function to return a Integer value which is given by user.
	 */
	
	public static int retInt()
	{
		return scr.nextInt();
	}
	
	

	/*
	 * function to return a word of String value which is given by user.
	 */
	public static String retNext()
	{
		return scr.next();
	}
	
	

	/*
	 * function to return a String line which is given by user.
	 */
	public static String retNextLine()
	{
		return scr.nextLine();
	}
	
	
	

	/**
	 * function to replace a proper username given by user with <<UserName>> from the template String
	 */
	
	public static String replaceUsrName()
	{
		String template="Hello <<UserName>>, How are you?";
		System.out.println(template);
		String uname=Utility.retNextLine();
		String t="";
		if(uname.length()<3)
		{
			System.out.println("enter a proper name. The username should have atleast 3 charecters");
			return null;
		}
		else
		{
			String[] templarr=template.split(" ");
			for(int i=0;i<templarr.length;i++)
			{
				if(templarr[i].equals("<<UserName>>,"))
				{
					templarr[i]=uname+",";
				}
			}
			for(int i=0;i<templarr.length;i++)
			{
				t=t+templarr[i]+" ";
			}
			
		}
		return t;

	}
	
	

	/**
	 * function to print the power of 2 upto the given range of power
	 * @param args takes the number upto which power of 2,the program should print
	 */
	
	public static void printPowOf2(int n)
	{
		if(n>=0 && n<31)
		{
			for(int i=0;i<=n;i++)
			{
				System.out.println("2^"+i+"="+(int)Math.pow(2, i));
			}
		}
		else
		{
			System.out.println("You have entered a number which is out of the range");
		}
	}
	/*
	 * function to check a year is leap year or not
	 * @return String message for Leap year or not
	 */
	
	public static String checkLeapYear()
	{
		int n=Utility.retInt();
		int m=n;
		int count=0;
		if(n>=1000 && n<=9999)
		{
			if(n%400==0 ||(n%4==0 && n%100!=0))
			{
				
				return "Leap Year";
			}
			else
			{
				
				return "not a Leap Year";
			}
		}
		else
		{
			return "You have entered a wrong year";
		}
	}
	
	/*
	 * function to print Nth harmonic number, i.e 1/1 + 1/2 + .... + 1/N
	 */
	public static void printNthHarmonic()
	{
		int n=Utility.retInt();
		double nthHarmonicNumber=0;
		if(n<0)
		{
			System.out.println("invalid number");
			
		}
		else
		{
			for(double i=1;i<=n;i++)//for floating point operations atleast one operand should be double or float
			{
				//System.out.println(1/i);
				nthHarmonicNumber+=1/i;
			}
			System.out.println("the "+n+"th"+" harmonic number is "+nthHarmonicNumber);;
		}

	}
	
	
	
	/*
	 * function to calculate percentage of head and tail after flipping a coin
	 */
	
	public static void PercentOfHeadTail()
	{
		int n=scr.nextInt();
		double tail=0,head=0;/*if you will declare tail and head as integer then there 
								will be a problem in the calculation i.e "(5/10)*100=0"
								and this problem can be solved by (5*100)/10=50*/
		double percentHead,percentTail;
		for(int i=1;i<n;i++)
		{
			if(Math.random()<0.5)
			{
				tail++;
			}
			else
			{
				head++;
			}
		}
		
		percentHead=(head/n)*100;
		percentTail=(tail/n)*100;
		
		System.out.println("percentage of head is "+percentHead);
		System.out.println("percentage of head is "+percentTail);
	}
}
