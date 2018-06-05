/**
 * 
 */
package com.bridgelabz.objectorientedprograms;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.bridgelabz.utility.Utility;

public class AddressBookManager 
{

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException 
	{
		AddressBook object=new AddressBook();
		String filePath="/home/adminstrato/BijayaWorkSpace/Basic/src/com/bridgelabz/objectorientedprograms/adsBookPersonDetails.json";
		for(int i=0;i<4;i++)
		{
		showOptions();
		}
		Utility.convertJavaToJson(object.getBook(), filePath);
	}

	private static void showOptions() 
	{
		System.out.println("What do you want?");
		System.out.println("1. Add a person");
		System.out.println("2. edit a persons details");
		System.out.println("3. delete a persons details");
		System.out.println("4. Sort entries by name");
		System.out.println("5. print entries");
		System.out.println("6. create a new address book");
		System.out.println("7. Open existing address book");
		System.out.println("9. Save address book");
		System.out.println("10. Quit program");
		System.out.println("select one option");
		int option=Utility.retInt();
		doSelectedOption(option);
	}

	private static void doSelectedOption(int option) 
	{
		AddressBook obj=new AddressBook();
		switch(option)
		{
		case 1:
			obj.getBook().add(obj.addPerson());
			break;
		case 2:
			System.out.println("select which persons detail you want to edit");
			AddressBook.showPersonFirstNames();
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		case 10:
			break;
		default:
			
		}
		
	}

}
