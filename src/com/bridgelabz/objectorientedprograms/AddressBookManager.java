/**
 * 
 */
package com.bridgelabz.objectorientedprograms;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.simple.parser.ParseException;

import com.bridgelabz.utility.Utility;
public class AddressBookManager 
{
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException, ParseException 
	{
		Storage storage=new Storage();
		AddressBook object=new AddressBook();
		String filePath="/home/adminstrato/BijayaWorkSpace/Basic/src/com/bridgelabz/objectorientedprograms/adsBookPersonDetails.json";
		object.addPerson();
	}

	/**
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ParseException
	 */
	static void showOptions() throws JsonGenerationException, JsonMappingException, IOException, ParseException 
	{
		System.out.println("What do you want?");
		System.out.println("1. Add a person");
		System.out.println("2. edit a persons details");
		System.out.println("3. delete a persons details");
		System.out.println("4. Sort entries by name");
		System.out.println("5. sort entries by zip");
		System.out.println("6. print entries");
		System.out.println("7. create a new address book");
		//System.out.println("8. Open existing address book");
		System.out.println("8. Quit program");
		System.out.println("select one option");
		int option=Utility.retInt();
		doSelectedOption(option);
	}

	/**
	 * @param option
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ParseException
	 */
	private static void doSelectedOption(int option) throws JsonGenerationException, JsonMappingException, IOException, ParseException 
	{
		AddressBook obj=new AddressBook();
		switch(option)
		{
		case 1:
			obj.addPerson();
			break;
		case 2:
			obj.printEntries();
			System.out.println("enter index of the person whose details you want to edit");
			int index=Utility.retInt();
			obj.editPerson(index);
			break;
		case 3:
			obj.printEntries();
			System.out.println("enter index of the person whose details you want to delete");
			int removeIndex=Utility.retInt();
			obj.removePerson(removeIndex);
			break;
		case 4:
			obj.sortByName();
			break;
		case 5:
			obj.sortByZipCode();
			break;
		case 6:
			obj.printEntries();
			break;
		case 7:
			obj.createNewAddressBook();
			break;
		case 8:
			obj.quitProgram();
			break;
		default:
			
		}
		
	}

}
