package com.bridgelabz.utility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Utility {

	static Scanner scr = new Scanner(System.in);

	
	
	/**********************************************************************
	 * @return number a user given number
	 *********************************************************************/
	public static int retInt() {         //function to return a Integer value which is given by user.
		return scr.nextInt();
	}

	
	/**
	 * @return String a user given word
	 */
	public static String retNext() {      //function to return a word of String value which is given by user.
		return scr.next();
	}

	
	/************************************************************************
	 * @return String a user given sentence/multiple words
	 *********************************************************************/
	public static String retNextLine() {       //function to return a String line which is given by user.
		return scr.nextLine();
	}



	/***********************************************************************
	 * @return boolean a user given boolen value
	 **********************************************************************/
	public static boolean retBoolean() {
		return scr.nextBoolean();
	}


	/*******************************************************************
	 * @return number a number which is of double type and is given by the user
	 *******************************************************************/
	public static double retDouble() {
		return scr.nextDouble();
	}
	
	

	/******************************************************************************
	 * Function to create the array of user's choice
	 * 
	 * @param noOfElements to store the array length to be created
	 * @param array to store the elements in the array
	 * @return the integer array created
	 ******************************************************************************/
	public static int[] createIntegerArray() {
		System.out.println("Enter the number of elements you want to store:-");
		int noOfElements = Utility.retInt();
		System.out.println("Enter the elements to be stored:-");
		int[] array = new int[noOfElements];
		for(int i=0; i<noOfElements; i++) {
			array[i] = Utility.retInt();
		}
		return array;
	}



	/*****************************************************************************
	 * function to replace a proper username given by user with <<UserName>> from
	 * the template String
	 * @param String template from which <<User Name>> should be replaced with actual/proper username
	 * @return String uname which is a proper name, given by the user
	 *********************************************************************/

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
	 * @param n number to print all the power value of 2 upto 'n'th power of 2
	 */
	public static void printPowOf2(int n) {         //function to print the power of 2 upto the given range of power
		if (n >= 0 && n < 31) {
			for (int i = 0; i <= n; i++) {
				System.out.println("2^" + i + "=" + (int) Math.pow(2, i));
			}
		} else {
			System.out.println("You have entered a number which is out of the range");
		}
	}
	
	/*******************************************************************
	 * @param year year to check for leap year
	 * @return String message for Leap year or not
	 *********************************************************************/
	public static String checkLeapYear(int year) {        //function to check a year is leap year or not
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

	
	/*********************************************************************
	 * @param n number upto which harmonic number should be calculated
	 * @return double which is the n'th harmonic number
	 *********************************************************************/
	public static double printNthHarmonic(int n) {         //function to print Nth harmonic number, i.e 1/1 + 1/2 + .... + 1/N
		
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

	

	/**********************************************************************
	 * @param numberOfTimes a number upto which a coin should be flipped
	 **********************************************************************/
	public static void PercentOfHeadTail(int numberOfTimes) {         //function to calculate percentage of head and tail after flipping a coin
		
		double tail = 0;
		double head = 0;/*
		 * if you will declare tail and head as integer then there will be a problem in
		 * the calculation i.e "(5/10)*100=0" and this problem can be solved by
		 * (5*100)/10=50
		 */
		double percentHead, percentTail;
		for (int i = 1; i < numberOfTimes; i++) {
			if (Math.random() < 0.5) {
				tail++;
			} else {
				head++;
			}
		}

		percentHead = (head / numberOfTimes) * 100;
		percentTail = (tail / numberOfTimes) * 100;

		System.out.println("percentage of head is " + percentHead);
		System.out.println("percentage of head is " + percentTail);
	}

	
	/***********************************************************************
	 * @param n a number of which all the prime factors is printed
	 * @return
	 ************************************************************************/
	public static Set printPrimeFactors(int n) {         //function to return all prime factors of a given number
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

	
	/*******************************************************************
	 * @param stake number that a player have
	 * @param goal number, the player have to make to win
	 * @param chance number of times the player is allowed to play
	 ******************************************************************/
	public static void calWinLossInGambling(int stake, int goal, int chance) {       //function to calculate the number of times a player wins and looses in gambling
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
	 * @param n
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
			break;
		default:
			System.out.println("you have given one invalid input");
		}

	}


	/**
	 * @param arr an array of type integer which has all the user given integers 
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

	/**
	 * @param firstPoint
	 * @param secondPoint
	 */
	public static double calEuclideanDistance(int firstPoint, int secondPoint) {
		double ans=Math.sqrt(Math.pow(firstPoint,2)*Math.pow(secondPoint, 2));
		return ans;
		
	}

	/**
	 * @param firstConstant
	 * @param secondConstant
	 * @param lastConstant
	 */
	public static double[] calRootsOfQuadraticEquation(int firstConstant, int secondConstant, int lastConstant) {
		double[] rootArray=new double[2];
		int delta=secondConstant*secondConstant-(4*firstConstant-lastConstant);
		double root1=0;
		double root2=0;
		double real=0;
		double imaginary=0;
		System.out.println("delta="+delta);
		if(delta<0)
		{
			real=(-secondConstant/(2*firstConstant));
			imaginary=Math.sqrt((-delta)/(2*firstConstant));
			root1=real+(2*imaginary);
			root2=real-(2*imaginary);
		}
		else if(delta>0)
		{
			real=(-secondConstant/(2*firstConstant));
			imaginary=Math.sqrt((delta)/(2*firstConstant));
			root1=real+(2*imaginary);
			root2=real-(2*imaginary);
		}
		else if(delta==0)
		{
			root1=root2=(-secondConstant/(2*firstConstant));
		}
		rootArray[0]=root1;
		rootArray[1]=root2;
		return rootArray;
		
	}

	/**
	 * @param tempratureInfahrenheit
	 * @param windSpeedInMilesPerHour
	 * @return
	 */
	public static double defineWeather(double tempratureInfahrenheit, double windSpeedInMilesPerHour) {
		if(tempratureInfahrenheit<50 && ( windSpeedInMilesPerHour<120 ||windSpeedInMilesPerHour>3))
		{
			double weather=35.75 + (0.6215 * tempratureInfahrenheit) + ((0.4275*tempratureInfahrenheit) - 35.75)*Math.pow(windSpeedInMilesPerHour, 0.16);
			return weather;
		}
		else
			return 0.0;
		
	}
	
	
	/**
	 * @param max
	 * @param min
	 * @return
	 */
	public static int randomWithRange(int max,int min)
	{
		int range=(max-min)+1;
		return (int)(Math.random()*range)+min;
	}


	/**
	 * @param string whose spaces will be removed
	 * @return String returns a string without space 
	 */
	public static String removeSapce(String string) 
	{
		String temprary="";
		for(int i=0;i<string.length();i++)
		{
			if(string.charAt(i)!=' ')
			{
				temprary=temprary+string.charAt(i);
			}
			
		}
		return temprary;
	}


	
	/**
	 * @param array
	 * @return
	 */
	public static int[] intBubbleSort(int[] array)
	{
		
		for(int i=0;i<array.length-1;i++)
		{
			for(int j=i+1;j<array.length;j++)
			{
				if(array[i]>array[j])
				{
					int temprary=array[i];
					array[i]=array[j];
					array[j]=temprary;
				}
			}
		}
		for(int i=0;i<array.length;i++)
		{
			System.out.println(array[i]);
		}
		return array;
	}


	/**
	 * @param number
	 * @return
	 */
	public static boolean isPrime(int number) 
	{
		if(number<2)
		{
			return false;
		}
		for(int i=2;i<number/2;i++)
		{
			if((number%i)==0)
			{
				return false;
			}
		}
		return true;
	}


	/**
	 * @param i
	 * @return
	 */
	public static boolean isPallindrome(int number) 
	{
		int copyNumber=number;
		int reverseNumber=0;
		while(copyNumber>0)
		{
			reverseNumber=reverseNumber*10+(copyNumber%10);
			copyNumber=copyNumber/10;
		}
		if(reverseNumber==number)
		{
			return true;
		}
		return false;
	}


	/**
	 * @param number1
	 * @param number2
	 * @return
	 */
	public static boolean NumAnagramCheck(int number1, int number2) 
	{
		String tempNumber1=number1+"";
		String tempNumber2=number2+"";
		if(Utility.stringBubbleSortByLetter(tempNumber1).equals(Utility.stringBubbleSortByLetter(tempNumber2)))
		{
			return true;
		}
		return false;
	}
	
	
	/**
	 * @param array
	 * @param search
	 * @return
	 */
	
	
	public static <T extends Comparable<T>> T maxOfThree(T x,T y,T z)
	{
		if(x.compareTo(y)>0 && x.compareTo(z)>0)
		{
			return x;
		}
		else if(y.compareTo(x)>0 && y.compareTo(z)>0)
		{
			return y;
		}
		else
			return z;
		
	}
	
	
	public static String stringBubbleSortByLetter(String string) 
	{
		char[] array=string.toCharArray();
		char temporary=' ';
		for(int i=0;i<string.length()-1;i++)
		{
			for(int j=0;j<string.length()-1-i;j++)
			{
				if(array[j]>array[j+1])
				{
					temporary=array[j];
					array[j]=array[j+1];
					array[j+1]=temporary;
				}
			}
		}
		string=new String(array);
		return string;
	}
	
}
