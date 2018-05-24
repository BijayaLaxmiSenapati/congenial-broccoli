/**
 * 
 */
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utility.Utility;

public class DayOfWeek {

	public static void main(String[] args)
	{
		int day=Integer.parseInt(args[0]);
		int month=Integer.parseInt(args[1]);
		int year=Integer.parseInt(args[2]);
		String[] week= {"Sunday","Monday","Tuesday","Wednesday","Thurseday","Friday","Saturday"};
		int result=Utility.dayOfWeek(day, month, year);
		System.out.println("the given date is "+week[result]);

	}

}
