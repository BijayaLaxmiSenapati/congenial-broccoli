/**
 * ..
 */
package com.bridgelabz.datastructureprograms;

import com.bridgelabz.utility.Utility;

class WeekDays
{
	String[] days= {"S","M ","T ","W ","TH","F ","S   "};
	Integer[] dates= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
}
class CalenderQueue
{
	public static void main(String[] args)
	{
		String[] months= {" ","Jan","Feb","Mar","Apr","May","Jun","July","Aug","Sept","Oct","Nov","Dec"};
		MyQueue<String> queueDays=new MyQueue<>();
		MyQueue<Integer> queueDates=new MyQueue<>();
		WeekDays weekdays=new WeekDays();
		for(int i=0;i<weekdays.days.length;i++)
		{
			queueDays.enqueue(weekdays.days[i]);
		}
		for(int i=0;i<weekdays.dates.length;i++)
		{
			queueDates.enqueue(weekdays.dates[i]);
		}
		int date=1;
		int month=Integer.parseInt(args[0]);
		int year=Integer.parseInt(args[1]);
		Integer[] daysInMonths= {0,31,28,31,30,31,30,31,31,30,31,30,31};
		if(Utility.checkLeapYear(year).equals("Leap Year"))
		{
			daysInMonths[2]=29;
		}
		queueDays.display();
		System.out.println();
		System.out.println();
		if(Utility.isValidDate(date, month, year)==true)
		{
			int day=Utility.dayOfWeek(date, month, year);
			int tillDate=daysInMonths[month];
			int count=0;
			int j=0;
			for(int i=0;i<6;i++)
			{
				if(i==0 )
				{
					for(int k=0;k<day;k++)
					{
						//calender[i][j]="   ";
						System.out.print("   ");
						j++;
					}
				}
				for(j=day;j<7;j++)
				{	
					
					if(count<=tillDate)
					{
						if(count<=9)
						{
							//calender[i][j]=count+"  ";
							//count++;
							System.out.print(weekdays.dates[count]+"  ");
							count++;
						}
						else
						{
							//calender[i][j]=count+" ";
							//count++;
							System.out.print(weekdays.dates[count]+" ");
							count++;
						}
					}
					
				}
				day=0;
				System.out.println();
			}
		}
	}
}