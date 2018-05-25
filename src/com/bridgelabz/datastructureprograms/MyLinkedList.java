/**
 * 
 */
package com.bridgelabz.datastructureprograms;

public class MyLinkedList
{
	private Node first;
	private Node last;
	//
	private int count=0;
	/**
	 * @param element
	 */
	public void add(Object element)
	{
		if(first==null)
		{
			first=new Node(element);
			last=first;
			count++;
			return;
		}
		last.next=new Node(element);
		last=last.next;
		count++;
		return;
	}
	
	
	/**
	 * @return
	 */
	public int size()
	{
		return count;
	}
	
	/**
	 * @return
	 */
	public boolean isEmpty()
	{
		return(count==0);
		
	}
	
	
	
	/**
	 * @param position
	 * @param item
	 */
	public void insert(int index, Object element)
	{
		if(index>=size())
		{
			throw new IndexOutOfBoundsException();
		}
		if(index==0)
		{
			first=new Node(element,first);
			count++;
			return;
		}
		Node temp=first;
		for(int i=1;i<index;i++)
		{
			temp=temp.next;
		}
		temp.next=new Node(element,temp.next);
		count++;
	}
	
	
	/**
	 * 
	 */
	public void display()
	{
		Node temp=first;
		for(int i=0;i<size();i++)
		{
			System.out.println(temp.element);
			temp=temp.next;
		}
	}
	
	/**
	 * @param index
	 * @return
	 */
	public Object get(int index)
	{
		Node temp=first;
		for(int i=0;i<index;i++)
		{
			temp=temp.next;
		}
		return temp.element;
	}
	
	
	/**
	 * @param searchElement
	 * @return
	 */
	public boolean search(Object searchElement)
	{
		Node temp=first;
		for(int i=0;i<size();i++)
		{
			if(temp.element==searchElement)
			{
				return true;
			}
			temp=temp.next;
		}
		return false;
	}
	
	
	public int index(Object element)
	{
		Node temp=first;
		for(int i=0;i<size();i++)
		{
			if(temp.element==element)
			{
				return i;
			}
			temp=temp.next;
		}
		return -1;
	}
	
	/*public void remove(Object element)
	{
		Node temp=first;
		while(temp.next!=null)
		{
			if(temp.element==element )
			{
				temp=temp.next.next;
				return;
			}
			temp=temp.next;
		}
	}*/
	
	public void remove(int index)
	{
		
		if(index>=size())
		{
			throw new IndexOutOfBoundsException();
		}
		if(index==0)
		{
			first=first.next;
			count--;
			return;
		}
		Node temp = first;
		for(int i=0;i<index-1;i++)
		{
			temp=temp.next;
		}
		temp.next=temp.next.next;
		count--;
	}
	
	/*
	public int pop()
	{
		Node temp=first;
		while(temp.next!=null)
		{
			temp=temp.next;
		}
		int lastElement=(int)temp.element;
		Node tempForIteration=first;
		
		return lastElement;
	}*/
	
	
	public int pop(int index)
	{
		return 0;
	}
	
	
}
