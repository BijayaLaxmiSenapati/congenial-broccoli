/**
 * ..
 */
package com.bridgelabz.datastructureprograms;

public class MyDeque<T>
{
	MyLinkedList<T> mylinkedlist=new MyLinkedList<>();
	public MyDeque()
	{
		
	}
	public void addFront(T element)
	{
		if(mylinkedlist.size()==0)
		{
			mylinkedlist.add(element);
		}
		else
			mylinkedlist.insert(0, element);
	}
	public void addRear(T element)
	{
		if(mylinkedlist.size()==0)
		{
			mylinkedlist.add(element);
		}
		else
		{
			int index=mylinkedlist.size()-1;
			mylinkedlist.insert(index, element);
		}
	}
	public T removeFront()
	{
		T element=null;
		if(mylinkedlist.isEmpty())
		{
			System.out.println("MyDeque is already empty");
		}
		else
		{
			element=mylinkedlist.get(0);
			mylinkedlist.remove(0);
			//return element;
		}
		return element;
	}
	public T removeRear()
	{
		T element=null;
		if(mylinkedlist.isEmpty())
		{
			System.out.println("MyDeque is already empty");
		}
		else
		{
			int index=mylinkedlist.size()-1;
			element=mylinkedlist.get(index);
			mylinkedlist.remove(index);
			//return element;
		}
		return element;
	}
	public boolean isEmpty()
	{
		return mylinkedlist.isEmpty();
	}
	public int size()
	{
		return mylinkedlist.size();
	}
	public void display()
	{
		mylinkedlist.display();
	}
}
