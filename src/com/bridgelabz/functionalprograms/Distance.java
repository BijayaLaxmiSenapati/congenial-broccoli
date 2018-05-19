/**
 * 
 */
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

/**
 * @author adminstrato
 *
 */
public class Distance {

	
	public static void main(String[] args)
	{
		int firstPoint=Integer.parseInt(args[0]);
		int secondPoint=Integer.parseInt(args[1]);
		System.out.println(Utility.calEuclideanDistance(firstPoint,secondPoint));

	}

}
