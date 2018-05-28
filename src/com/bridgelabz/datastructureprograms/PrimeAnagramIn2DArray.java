/**
 * 
 */
package com.bridgelabz.datastructureprograms;

import com.bridgelabz.utility.Utility;

public class PrimeAnagramIn2DArray 
{

	public static void main(String[] args)
	{
		MyLinkedList mylinkedlist=new MyLinkedList();
		for(int i=0;i<=1000;i++)
		{
			if(Utility.isPrime(i))
			{
				mylinkedlist.add(i);
			}
		}
	}

}
