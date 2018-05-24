/**
 * 
 */
package datastructureprograms;

public class CheckingLinkedList {

	public static void main(String[] args)
	{
		MyLinkedList mylinkedlist=new MyLinkedList();
		mylinkedlist.add(10);
		mylinkedlist.add(20);
		mylinkedlist.add(30);
		mylinkedlist.display();
		System.out.println("element at index 1 is "+mylinkedlist.get(1));
		System.out.println("is 40 present? "+mylinkedlist.search(40));
		System.out.println("index of 40 is "+mylinkedlist.index(40));
	}

}
