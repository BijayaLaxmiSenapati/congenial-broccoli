/**
 * 
 */
package com.bridgelabz.datastructureprograms;

import com.bridgelabz.utility.Utility;

public class PrimeAnagramUsingStack 
{
	
	public static void main(String[] args) 
	{
		MyLinkedList<Integer> mylinkedlist=new MyLinkedList<Integer>();
		MyStack<Integer> mystack=new MyStack<Integer>();
		for(int i=0;i<=1000;i++)
		{
			if(Utility.isPrime(i))
			{
				mylinkedlist.add(i);
			}
		}
	
		for(int i=0;i<mylinkedlist.size()-1;i++)
		{
			for(int j=i+1;j<mylinkedlist.size();j++)
			{
				if(Utility.numAnagramCheck(mylinkedlist.get(i),mylinkedlist.get(j)))
				{
					mystack.push(mylinkedlist.get(i));
					mystack.push(mylinkedlist.get(j));
				}
			}
		}
		mystack.display();
		
	}

}
