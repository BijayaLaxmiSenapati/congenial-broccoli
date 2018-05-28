/**
 * 
 */
package com.bridgelabz.datastructureprograms;

public class MyLinkedList<T>
{
	private Node<T> first;
	private Node<T> last;
	private int count=0;
	public MyLinkedList()
	{
		
	}
	/**
	 * @param element
	 */
	public void add(T element)
	{
		if(first==null)
		{
			first=new Node<T>(element);
			last=first;
			count++;
			return;
		}
		last.next=new Node<T>(element);
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
	public void insert(int index, T element)
	{
		if(index>=size())
		{
			throw new IndexOutOfBoundsException();
		}
		if(index==0)
		{
			first=new Node<T>(element,first);
			count++;
			return;
		}
		Node<T> temp=first;
		for(int i=1;i<index;i++)
		{
			temp=temp.next;
		}
		temp.next=new Node<T>(element,temp.next);
		count++;
	}
	
	
	/**
	 * 
	 */
	public void display()
	{
		Node<T> temp=first;
		System.out.print("[");
		for(int i=0;i<size();i++)
		{
			System.out.print(temp.element+",");
			temp=temp.next;
		}
		System.out.print("]");
	}
	
	/**
	 * @param index
	 * @return
	 */
	public T get(int index)
	{
		if(index>=size())
		{
			throw new IndexOutOfBoundsException();
		}
		Node<T> temp=first;
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
	public boolean search(T searchElement)
	{
		Node<T> temp=first;
		for(int i=0;i<size();i++)
		{
			if(temp.element.equals(searchElement))
			{
				return true;
			}
			temp=temp.next;
		}
		return false;
	}
	
	
	public int index(T element)
	{
		Node<T> temp=first;
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
	
	public void remove(T element)
	{
		Node<T> temp=first;
		Node<T> previous=null;
		if(first.element==element)
		{
			first=first.next;
			count--;
			return;
		}
		while(temp.next!=null)
		{
			if(temp.element==element)
			{
				previous.next=temp.next;
				count--;
				return;
			}
			previous=temp;
			temp=temp.next;
		}
		if(temp.next==null)
		{
			previous.next=null;
			count--;
		}
	}
	
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
		Node<T> temp = first;
		for(int i=0;i<index-1;i++)
		{
			temp=temp.next;
		}
		temp.next=temp.next.next;
		count--;
	}
	
	
	public Object pop()
	{
		Node<T> temp=first;
		Node<T> previous=null;
		while(temp.next!=null)
		{
			previous=temp;
			temp=temp.next;
		}
		Object lastElement=temp.element;
		previous.next=null;
		count--;
		return lastElement;
		
	}
	
	
	public Object pop(int index)
	{
		if(index>=size())
		{
			throw new IndexOutOfBoundsException();
		}
		if(index==0)
		{
			Object firstElement=first.element;
			first=first.next;
			count--;
			return firstElement;
		}
		Node<T> temp = first;
		for(int i=0;i<index-1;i++)
		{
			temp=temp.next;
		}
		Object elementAtIndex=temp.next.element;
		temp.next=temp.next.next;
		count--;
		return elementAtIndex;
	}
	
	
}
