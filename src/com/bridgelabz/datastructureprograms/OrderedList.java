/**
 * ..
 */
package com.bridgelabz.datastructureprograms;

import com.bridgelabz.utility.Utility;

public class OrderedList 
{
	static MyLinkedList<Integer> mylinkedlist=new MyLinkedList<Integer>();
	public static void main(String[] args)
	{
		Utility utility=new Utility();
		String fileName="/home/adminstrato/BijayaWorkSpace/numbersWithComma";
		String readedFile=utility.readAllFromFile(fileName);
		String[] numArray=readedFile.split(",");
		Integer[] array=new Integer[numArray.length];
		for(int i=0;i<numArray.length;i++)
		{
			array[i]=Integer.parseInt(numArray[i]);
		}
		mylinkedlist.add(array[0]);
		for(int i=1;i<array.length;i++)
		{
			checkAndAdd(array[i]);
		}
		System.out.println("linked list elements are:");
		mylinkedlist.display();
		System.out.println("enter which number you want to search");
		Integer searchNumber=Utility.retInt();
		if(mylinkedlist.search(searchNumber))
		{
			int deleteIndexElement=mylinkedlist.index(searchNumber);
			mylinkedlist.pop(deleteIndexElement);
		}
		else
		{
			checkAndAdd(searchNumber);
		}
		System.out.println("linked list elements are:");
		mylinkedlist.display();
	}

	private static void checkAndAdd(Integer element)
	{
		int count=0;
		for(int i=0;i<mylinkedlist.size();i++)
		{
			if(element.compareTo(mylinkedlist.get(i))>0)
			{
				count++;
				continue;
			}
			mylinkedlist.insert(count, element);
			return;
		}
		mylinkedlist.add(element);
	}

}
