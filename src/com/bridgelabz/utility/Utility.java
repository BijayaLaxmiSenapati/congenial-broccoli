package com.bridgelabz.utility;

import java.util.Scanner;

public class Utility 
{
	static Scanner scr=new Scanner(System.in);
	public static int retInt()
	{
		return scr.nextInt();
	}
	
	public static String retNext()
	{
		return scr.next();
	}
	
	public static String retNextLine()
	{
		return scr.nextLine();
	}
	
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
}
