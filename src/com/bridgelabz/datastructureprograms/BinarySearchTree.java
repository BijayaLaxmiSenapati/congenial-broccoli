/**
 * ..
 */
package com.bridgelabz.datastructureprograms;

import com.bridgelabz.utility.Utility;

public class BinarySearchTree {

	public static void main(String[] args) 
	{
		System.out.println("enter the number of test cases");
		int testCase=Utility.retInt();
		int index=0;
		int[] nodesArray=new int[testCase];
		int[] resultArray=new int[testCase];
		for(int i=0;i<testCase;i++)
		{
			System.out.println("enter the number of nodes");
			nodesArray[index]=Utility.retInt();
			resultArray[index]=Utility.numberOfBinaryTree(nodesArray[i]);
			System.out.println("Using "+nodesArray[index]+" nodes "+resultArray[index]+" \"Binary Search Tree\" can be created.");
			index++;
		}
	}

}
