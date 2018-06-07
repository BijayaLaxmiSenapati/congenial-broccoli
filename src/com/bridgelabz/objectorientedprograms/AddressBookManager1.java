/**
 * 
 */
package com.bridgelabz.objectorientedprograms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.utility.Utility;

public class AddressBookManager1 
{
	List<String> listOfAddressBook;
	
	public AddressBookManager1(String fileLocation) 
	{
		if(listOfAddressBook == null) {
			
				listOfAddressBook = Utility.convertJsonToList(fileLocation);
			
		}
		else {
			System.out.println("No Address Book created");
			listOfAddressBook = new ArrayList<>();
		}
	}
	
	static void showOptions()
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

	
	private static void doSelectedOption(int option)
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
			obj.sortByLastName();
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
	
	public void addPerson()
	{
		String firstName="";
		String lastName="";
		String address="";
		String city="";
		String state="";
		String zip="";
		String phoneNumber="";
		System.out.println("for adding person details to the address book");
		System.out.println("Enter the \"First Name\"");
		firstName=Utility.retNext();
		System.out.println("Enter the \"Last Name\"");
		lastName=Utility.retNext();
		System.out.println("Enter the \"Address\"");
		address=Utility.retNext();
		System.out.println("Enter the \"City\"");
		city=Utility.retNext();
		System.out.println("Enter the \"State\"");
		state=Utility.retNext();
		System.out.println("Enter the \"Zip Code\"");
		zip=Utility.retNext();
		System.out.println("Enter the \"Phone Number\"");
		phoneNumber=Utility.retNext();
		Person person=new Person(firstName, lastName, address, city, state, zip, phoneNumber);
		persons.add(person);
		Utility.convertJavaToJson(persons, filePath);
		addressBookManager.showOptions();
	}

	

	public void printEntries()
	{
		JSONParser parser=new JSONParser();
		Object object = null;
		try 
		{
			object = parser.parse(new FileReader(filePath));
		}
		catch (ParseException e) 
		{
			
			e.printStackTrace();
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		//JSONObject jsonObject=(JSONObject)object;
		JSONArray jsonArray=(JSONArray)object;
		for(int i=0;i<jsonArray.size();i++)
		{
			JSONObject object1=(JSONObject)jsonArray.get(i);
			System.out.print("index="+i);
			System.out.println(object1);
		}
	}
	
	
	
	public void quitProgram()
	{
		System.out.println("DO YOU REALLY WANT TO QUIT THE PROGRAM ?");
		System.out.println("if yes then enter 0");
		int exitSurance=Utility.retInt();
		if(exitSurance==0)
		{
			System.out.println("Thanks! Visit again");
			System.exit(0);
		}
		addressBookManager.showOptions();
	}

	
	public void editPerson(int index)
	{
		System.out.println("Enter what you want to change");
		System.out.println("To change address, enter 1");
		System.out.println("To change city, enter 2");
		System.out.println("To change state, enter 3");
		System.out.println("To change zip code, enter 4");
		System.out.println("To change phone number, enter 5");
		int option=Utility.retInt();
		switch(option)
		{
		case 1:
			System.out.println("Enter the new address");
			String newAddress=Utility.retNext();
			persons.get(index).setAddress(newAddress);
			Utility.convertJavaToJson(persons, filePath);
			printEntries();
			addressBookManager.showOptions();
			break;
		case 2:
			System.out.println("Enter the new city name");
			String newCity=Utility.retNext();
			persons.get(index).setAddress(newCity);
			Utility.convertJavaToJson(persons, filePath);
			printEntries();
			addressBookManager.showOptions();
			break;
		case 3:
			System.out.println("Enter the new state name");
			String newState=Utility.retNext();
			persons.get(index).setAddress(newState);
			Utility.convertJavaToJson(persons, filePath);
			printEntries();
			addressBookManager.showOptions();
			break;
		case 4:
			System.out.println("Enter the new zip code");
			String newZipCode=Utility.retNext();
			persons.get(index).setAddress(newZipCode);
			Utility.convertJavaToJson(persons, filePath);
			printEntries();
			addressBookManager.showOptions();
			break;
		case 5:
			System.out.println("Enter the new Phone number");
			String newPhoneNum=Utility.retNext();
			persons.get(index).setAddress(newPhoneNum);
			Utility.convertJavaToJson(persons, filePath);
			printEntries();
			addressBookManager.showOptions();
			break;
		default:
			System.out.println("wrong option selected");
			addressBookManager.showOptions();
		}
	}

	
	
	public void removePerson(int removeIndex)
	{
		persons.remove(persons.get(removeIndex));
		Utility.convertJavaToJson(persons, filePath);
		printEntries();
		addressBookManager.showOptions();
	}

	public void sortByLastName()
	{
		
		for(int i=0;i<persons.size()-1;i++)
		{
			for(int j=i+1;j<persons.size();j++)
			{
				if(persons.get(i).getLastName().compareTo(persons.get(j).getLastName())>0)
				{
					Person temporary=persons.get(i);
					persons.set(i,persons.get(j));
					persons.set(j, temporary);
				}
				else if(persons.get(i).getLastName().compareTo(persons.get(j).getLastName())==0)
				{
					sortByFirstName(persons.get(i), i, persons.get(j), j);
				}
			}
		}
		Utility.convertJavaToJson(persons, filePath);
		printEntries();
		addressBookManager.showOptions();
	}
	
	
	public void sortByFirstName(Person person1 , int i , Person person2, int j)
	{
		if(person1.getFirstName().compareTo(person2.getFirstName())>0)
		{
			Person temp=persons.get(i);
			persons.set(i, persons.get(j));
			persons.set(j, temp);
		}
	}


	public void sortByZipCode()
	{
		for(int i=0;i<persons.size()-1;i++)
		{
			for(int j=i+1;j<persons.size();j++)
			{
				if(persons.get(i).getZip().compareTo(persons.get(j).getZip())>0)
				{
					Person temporary=persons.get(i);
					persons.set(i,persons.get(j));
					persons.set(j, temporary);
				}
				else if(persons.get(i).getZip().compareTo(persons.get(j).getZip())==0)
				{
					sortByFirstName(persons.get(i), i, persons.get(j), j);
				}
			}
		}
		Utility.convertJavaToJson(persons, filePath);
		printEntries();
		AddressBookManager.showOptions();
	}

	public void createNewAddressBook() 
	{
		System.out.println("enter the name of the address book which you want to create");
		String name=fileLocation+Utility.retNext()+".json";
		File fl=new File(name);
		try 
		{
			if(fl.createNewFile())
			{
				System.out.println("New Address Book is Created");
				addressBookList.add(name);
			}
			else
			{
				System.out.println("address book not created");
			}
		} 
		catch (IOException e) 
		{

			e.printStackTrace();
		}
	}

	public void viewAllAddressBook() 
	{
		for(int i=0;i<addressBookList.size();i++)
		{
			System.out.print("index="+i);
			System.out.println(addressBookList.get(i));
		}
		
	}

	public void openAddressBook(int indexOfFileList) 
	{
		String select=addressBookList.get(indexOfFileList);
		//Utility.convertJsonToList(select,)
		
	}

	public void deleteAddressBook() 
	{
		
		
	}

}
