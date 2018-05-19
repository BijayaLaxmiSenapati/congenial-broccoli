/**
 * 
 */
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

/**
 * @author adminstrato
 *
 */
public class StopWatch {

	public static void main(String[] args) {
		long startTime=0;
		long stopTime=0;
		System.out.println("enter 1 to start the stopwatch");
		int input=Utility.retInt();
		int flag=0;
		while(flag==0)
		{
			switch(input)
			{
			case 1:
				startTime=System.nanoTime();
				System.out.println("enter 0 to stop the stopwatch");
				input=Utility.retInt();
				break;
			case 0:
				stopTime=System.nanoTime();
				flag=1;
			}
		}
		long elapsedTime=stopTime-startTime;
		System.out.println("startTime= "+startTime);
		System.out.println("stopTime= "+stopTime);
		if(startTime!=0)
		{
			System.out.println("elapsedTime= "+elapsedTime);
		}
		else
			System.out.println("To start the stopwatch you should have pressed 0 only");

	}

}
