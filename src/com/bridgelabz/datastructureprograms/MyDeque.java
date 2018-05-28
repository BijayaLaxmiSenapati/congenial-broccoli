/**
 * 
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
		mylinkedlist.insert(0, element);
	}
	public void addRear(T element)
	{
		int index=mylinkedlist.size()-1;
		mylinkedlist.insert(index, element);
	}
	public T removeFront()
	{
		if(mylinkedlist.isEmpty())
		{
			System.out.println("MyDeque is already empty");
		}
		T element=mylinkedlist.get(0);
		mylinkedlist.remove(0);
		return element;
	}
	public T removeRear()
	{
		if(mylinkedlist.isEmpty())
		{
			System.out.println("MyDeque is already empty");
		}
		int index=mylinkedlist.size()-1;
		T element=mylinkedlist.get(index);
		mylinkedlist.remove(index);
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
