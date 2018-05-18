package com.bridgelabz.utility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Utility {

	static Scanner scr = new Scanner(System.in);

	/*
	 * function to return a Integer value which is given by user.
	 */

	public static int retInt() {
		return scr.nextInt();
	}

	/*
	 * function to return a word of String value which is given by user.
	 */
	public static String retNext() {
		return scr.next();
	}

	/*
	 * function to return a String line which is given by user.
	 */
	public static String retNextLine() {
		return scr.nextLine();
	}



	/**
	 * @return
	 */
	public static boolean retBoolean() {
		return scr.nextBoolean();
	}


	/**
	 * @return
	 */
	public static double retDouble() {
		return scr.nextDouble();
	}



	/**
	 * function to replace a proper username given by user with <<UserName>> from
	 * the template String
	 * @param String 
	 * @return String
	 */

	public static String replaceUsrName(String template,String uname) {
		
		String t = "";
		if (uname.length() < 3) {
			System.out.println("enter a proper name. The username should have atleast 3 charecters");
			return null;
		} else {
			String[] templarr = template.split(" ");
			for (int i = 0; i < templarr.length; i++) {
				if (templarr[i].equals("<<UserName>>,")) {
					templarr[i] = uname + ",";
				}
			}
			for (int i = 0; i < templarr.length; i++) {
				t = t + templarr[i] + " ";
			}

		}
		return t;

	}

	/**
	 * function to print the power of 2 upto the given range of power
	 * 
	 * @param args
	 *            takes the number upto which power of 2,the program should print
	 */

	public static void printPowOf2(int n) {
		if (n >= 0 && n < 31) {
			for (int i = 0; i <= n; i++) {
				System.out.println("2^" + i + "=" + (int) Math.pow(2, i));
			}
		} else {
			System.out.println("You have entered a number which is out of the range");
		}
	}
	/*
	 * function to check a year is leap year or not
	 * @param 
	 * @return String message for Leap year or not
	 */

	public static String checkLeapYear(int year) {
		int count = 0;
		if (year >= 1000 && year <= 9999) {
			if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {

				return "Leap Year";
			} else {

				return "not a Leap Year";
			}
		} else {
			return "You have entered a wrong year";
		}
	}

	/*
	 * function to print Nth harmonic number, i.e 1/1 + 1/2 + .... + 1/N
	 */
	public static double printNthHarmonic(int n) {
		
		double nthHarmonicNumber = 0;
		if (n < 0) {
			System.out.println("invalid number");

		} else {
			for (double i = 1; i <= n; i++)// for floating point operations atleast one operand should be double or
				// float
			{
				// System.out.println(1/i);
				nthHarmonicNumber += 1 / i;
			}
			
		}
		return nthHarmonicNumber;

	}

	/*
	 * function to calculate percentage of head and tail after flipping a coin
	 */

	public static void PercentOfHeadTail() {
		int n = scr.nextInt();
		double tail = 0;
		double head = 0;/*
		 * if you will declare tail and head as integer then there will be a problem in
		 * the calculation i.e "(5/10)*100=0" and this problem can be solved by
		 * (5*100)/10=50
		 */
		double percentHead, percentTail;
		for (int i = 1; i < n; i++) {
			if (Math.random() < 0.5) {
				tail++;
			} else {
				head++;
			}
		}

		percentHead = (head / n) * 100;
		percentTail = (tail / n) * 100;

		System.out.println("percentage of head is " + percentHead);
		System.out.println("percentage of head is " + percentTail);
	}

	/*
	 * function to return all prime factors of a given number
	 */
	public static Set printPrimeFactors(int n) {
		Set s = new HashSet();
		while (n % 2 == 0) 
		{
			s.add(2);
			n = n / 2;
		}
		for (int i = 3; i <= Math.sqrt(n); i = i + 2) {
			if (n % i == 0) 
			{
				s.add(i);
				n = n / i;
			}
		}
		if (n > 2) {
			s.add(n);
		}
		return s;
	}

	/*
	 * function to calculate the number of times a player wins and looses in
	 * gambling
	 */
	public static void calWinLossInGambling(int stake, int goal, int chance) {
		int win = 0, loss = 0;

		for (int i = 1; i < chance; i++) {
			while (stake < goal && stake > 0 && chance > 0) {
				if (Math.random() >= 0.5)
				{
					stake++;
					win++;
					chance--;
				} 
				else 
				{
					stake--;
					loss++;
					chance--;
				}
			}
		}
		double percentWin = (win * 100) / (win + loss);
		double percentLoss = (loss * 100) / (win + loss);
		System.out.println("the player won " + win + " times.");
		System.out.println("the player lost " + loss + " times.");
		System.out.println("percentage of win is " + percentWin + "%");
		System.out.println("percentage of loss is " + percentLoss + "%");
	}

	/**
	 * @return
	 */
	public static int generateCoupNum(int n) 
	{
		
		Random rand = new Random();
		List<Integer> arr = new ArrayList<>(n);
		arr.add(rand.nextInt(10));
		int count = 1;
		int j = 1;
		while (j <= n) {
			int r = rand.nextInt(10);
			if (arr.contains(r)) {

				count++;
				continue;
			} else {
				count++;
				arr.add(r);
				j++;
			}
		}
		return count;
	}



	public static void print2DArray(int n)
	{
		System.out.println("enter number of rows of the 2D array");
		int row=Utility.retInt();
		System.out.println("enter number of columns of the 2D array");
		int col=Utility.retInt();
		System.out.println("enter elements of the 2D array row wise");
		int[][] inta;
		double[][] doublea1;
		boolean[][] boola;
		switch(n)
		{
		case 1:
			inta=new int[row][col];
			for(int i=0;i<row;i++)
			{
				for(int j=0;j<col;j++)
				{
					inta[i][j]=Utility.retInt();
				}
			}
			for(int i=0;i<row;i++)
			{
				for(int j=0;j<col;j++)
				{
					System.out.print(inta[i][j]+" ");
				}
				System.out.println();
			}
			break;
		case 2:
			doublea1=new double[row][col];
			for(int i=0;i<row;i++)
			{
				for(int j=0;j<col;j++)
				{
					doublea1[i][j]=Utility.retDouble();
				}
			}
			for(int i=0;i<row;i++)
			{
				for(int j=0;j<col;j++)
				{
					System.out.print(doublea1[i][j]+" ");
				}
				System.out.println();
			}
			break;
		case 3:
			boola=new boolean[row][col];
			for(int i=0;i<row;i++)
			{
				for(int j=0;j<col;j++)
				{
					boola[i][j]=Utility.retBoolean();
				}
			}
			for(int i=0;i<row;i++)
			{
				for(int j=0;j<col;j++)
				{
					System.out.print(boola[i][j]+" ");
				}
				System.out.println();
			}
		default:
			System.out.println("you have given one invalid input");
		}

	}


	/**
	 * @param arr
	 */
	public static void combineToGetZero(int[] arr)
	{
		int count=0;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				for(int k=j+1;k<arr.length;k++)
				{
					if(arr[i]+arr[j]+arr[k]==0)
					{
						count++;
						System.out.println(arr[i]+"+"+arr[j]+"+"+arr[k]);
					}
				}
			}
		}

	}
}
