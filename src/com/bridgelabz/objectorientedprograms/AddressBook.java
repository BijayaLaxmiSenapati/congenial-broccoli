/**
 * 
 */
package com.bridgelabz.objectorientedprograms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.utility.Utility;

public class AddressBook 
{
	String fileLocation="/home/adminstrato/BijayaWorkSpace/Basic/src/com/bridgelabz/objectorientedprograms/";
	private static ArrayList<Person> persons=new ArrayList<>();
	ArrayList<String> addressBookList=new ArrayList();                                                                             
	
	public ArrayList<Person> getBook() {
		return persons;
	}

	public void setBook(ArrayList<Person> book) {
		this.persons = book;
	}
	
	//static Storage storage=new Storage();
	static String filePath="/home/adminstrato/BijayaWorkSpace/Basic/src/com/bridgelabz/objectorientedprograms/adsBookPersonDetails.json";
	static AddressBookManager addressBookManager=new AddressBookManager();
	
	
	AddressBook()
	{
			
			ObjectMapper mapper=new ObjectMapper();
			try 
			{
				persons=mapper.readValue(new File(filePath), new TypeReference<ArrayList<Person>>() {});
			} 
			catch (IOException e) 
			{
				System.out.println("Address book is empty... first add some persons data");
				//e.printStackTrace();
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

	/*public void printEntries() //by arraylist
	{
		for(int i=0;i<storage.getBook().size();i++)
		{
			System.out.println("index= "+i);
			System.out.println("FIRST NAME "+storage.getBook().get(i).getFirstName());
			System.out.println("LAST NAME "+storage.getBook().get(i).getLastName());
			System.out.println("ADDRESS "+storage.getBook().get(i).getAddress());
			System.out.println("CITY "+storage.getBook().get(i).getCity());
			System.out.println("STATE "+storage.getBook().get(i).getState());
			System.out.println("ZIP CODE "+storage.getBook().get(i).getZip());
			System.out.println("PHONE NUMBER "+storage.getBook().get(i).getPhoneNumber());
			System.out.println();
			System.out.println();
		}
		
	}
*/
	
	/**
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
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
		
		
		
		/*ArrayList<Person> tempArray=new ArrayList();
		ObjectMapper mapper=new ObjectMapper();
		try 
		{
			tempArray=mapper.readValue(new File(filePath), new TypeReference<ArrayList<Person>>() {});
			for(int i=0;i<tempArray.size();i++)
			{
				System.out.print("index= "+i);
				System.out.println(tempArray.get(i));
			}
		} 
		catch (IOException e) 
		{
			//System.out.println("Address book is empty... first add some persons data");
			e.printStackTrace();
		}*/
	}
	/**
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ParseException
	 */
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

	/**
	 * @param index
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ParseException 
	 */
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

	/**
	 * @param removeIndex
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ParseException 
	 */
	public void removePerson(int removeIndex)
	{
		persons.remove(persons.get(removeIndex));
		Utility.convertJavaToJson(persons, filePath);
		printEntries();
		addressBookManager.showOptions();
	}

	public void sortByLastName()
	{
		/*String[] names=new String[storage.getBook().size()];
		for(int i=0;i<names.length;i++)
		{
			names[i]=storage.getBook().get(i).getLastName();
		}
		Arrays.sort(names);
		for(int i=0;i<names.length;i++)
		{
			for(int j=0;j<names.length;j++)
			{
				if(names[i].equals(storage.getBook().get(j).getLastName()))
				{
					Person temp=storage.getBook().get(i);
					storage.getBook().set(i, storage.getBook().get(j));
					storage.getBook().set(j, temp);
					break;
				}
			}
		}
		Utility.convertJavaToJson(storage, filePath);
		addressBookManager.showOptions();*/
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

	/**
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ParseException 
	 */
	public void sortByZipCode()
	{/*
		String[] zipCodes=new String[storage.getBook().size()];
		for(int i=0;i<zipCodes.length;i++)
		{
			zipCodes[i]=storage.getBook().get(i).getZip();
		}
		Arrays.sort(zipCodes);
		for(int i=0;i<zipCodes.length;i++)
		{
			for(int j=0;j<zipCodes.length;j++)
			{
				if(zipCodes[i].equals(storage.getBook().get(j).getZip()))
				{
					Person temp=storage.getBook().get(i);
					storage.getBook().set(i, storage.getBook().get(j));
					storage.getBook().set(j, temp);
					break;
				}
			}
		}*/
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
