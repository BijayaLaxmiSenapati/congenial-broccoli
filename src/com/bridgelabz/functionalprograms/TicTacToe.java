/**
 * 
 */
package com.bridgelabz.functionalprograms;

import java.util.Random;

import com.bridgelabz.utility.Utility;

/**
 * @author adminstrato
 *
 */
public class TicTacToe
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Random random=new Random();
		char[][] box=new char[3][3];
		int l1=0;
		int l2=0;
		int count=1;
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				box[i][j]=' ';
			}
		}

		//system will give the first input, so it is outside the while loop
		l1=random.nextInt(3);
		l2=random.nextInt(3);
		box[l1][l2]='X';
		while(!checkForWin(box) || count!=8)
		{
			//it prints the contents of the box before asking input from the user
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{
					System.out.print(box[i][j]);
				}
				System.out.println();
			}
			System.out.println("enter the row number, which should be in between 0 to 2");
			l1=Utility.retInt();
			System.out.println("enter the col number, which should be in between 0 to 2");
			l2=Utility.retInt();
			if(box[l1][l2]!='X' && box[l1][l2]!='o' || (checkForWin(box) && count!=8))
			{
				box[l1][l2]='o';
				for(int i=0;i<3;i++)
				{
					for(int j=0;j<3;j++)
					{
						System.out.print(box[i][j]);
					}
					System.out.println();
				}
				count++;
			}
			else
			{
				continue;
			}
			
			//for system
			l1=random.nextInt(3);
			l2=random.nextInt(3);
			if(box[l1][l2]!='X' && box[l1][l2]!='o' || (checkForWin(box) && count!=8))
			{
				box[l1][l2]='X';
				for(int i=0;i<3;i++)
				{
					for(int j=0;j<3;j++)
					{
						System.out.print(box[i][j]);
					}
					System.out.println();
				}
				count++;
			}
			else
			{
				while(true)
				{
					l1=random.nextInt(3);
					l2=random.nextInt(3);
					if(box[l1][l2]!='X' && box[l1][l2]!='o' || (checkForWin(box) && count!=8))
					{
						box[l1][l2]='X';
						for(int i=0;i<3;i++)
						{
							for(int j=0;j<3;j++)
							{
								System.out.print(box[i][j]);
							}
							System.out.println();
						}
						count++;
						break;
					}
					else
					{
						continue;
					}
				}
			}
		}
		if(checkForWin(box))
		{
			System.out.println("either system or you won");
		}
		else if(count!=8)
		{
			System.out.println("lost");
		}
		/*for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(box[i][j]);
			}
			System.out.println();
		}*/
	}

	private static boolean checkForWin(char box[][]) 
	{
		return (checkRowWin(box) || checkColWin(box) || checkDiagonalWin(box));
	}

	private static boolean checkDiagonalWin(char box[][]) 
	{
		if(checkEqual(box[0][0], box[1][1], box[2][2]) || checkEqual(box[2][0], box[1][1], box[0][1]))
		{
			return true;
		}
		return false;
	}

	private static boolean checkColWin(char box[][]) 
	{
		char c1;
		char c2;
		char c3;
		for(int i=0;i<3;i++)
		{
			c1=box[0][i];
			c2=box[1][i];
			c3=box[2][i];
			if(checkEqual(c1,c2,c3))
			{
				return true;
			}
		}
		return false;
	}

	private static boolean checkRowWin(char box[][]) 
	{
		char c1;
		char c2;
		char c3;
		for(int i=0;i<3;i++)
		{
			c1=box[i][0];
			c2=box[i][1];
			c3=box[i][2];
			if(checkEqual(c1,c2,c3))
			{
				return true;
			}
		}
		return false;
	}

	private static boolean checkEqual(char c1, char c2, char c3) 
	{
		
		return ((c1!=' ')&&(c1==c2)&&(c2==c3));
	}
}