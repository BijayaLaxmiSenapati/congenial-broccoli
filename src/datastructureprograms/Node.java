/**
 * 
 */
package datastructureprograms;

public class Node
{
	Object element;
	Node next;
	Node(Object element)
	{
		this.element=element;
	}
	Node(Object element,Node next)
	{
		this.element=element;
		this.next=next;
	}
}
