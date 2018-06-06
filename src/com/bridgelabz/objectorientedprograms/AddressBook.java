/**
 * 
 */
package com.bridgelabz.objectorientedprograms;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.utility.Utility;

public class AddressBook 
{
	//private static ArrayList<Person> book=new ArrayList<>();
	static Storage storage=new Storage();
	static String filePath="/home/adminstrato/BijayaWorkSpace/Basic/src/com/bridgelabz/objectorientedprograms/adsBookPersonDetails.json";
	static AddressBookManager addressBookManager=new AddressBookManager();

	/*public ArrayList<Person> getBook() {
		return book;
	}

	public void setBook(ArrayList<Person> book) {
		this.book = book;
	}*/


	/**
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void addPerson() throws JsonGenerationException, JsonMappingException, IOException, ParseException 
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
		storage.getBook().add(person);
		Utility.convertJavaToJson(storage, filePath);
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
	public void printEntries() throws FileNotFoundException, IOException, ParseException
	{
		JSONParser parser=new JSONParser();
		Object object=parser.parse(new FileReader(filePath));
		JSONObject jsonObject=(JSONObject)object;
		JSONArray jsonArray=(JSONArray)jsonObject.get("book");
		for(int i=0;i<jsonArray.size();i++)
		{
			JSONObject object1=(JSONObject)jsonArray.get(i);
			System.out.print("index="+i);
			System.out.println(object1);
			//totalRiceCost+=(long)object1.get("weight")*(long)object1.get("price");
		}
	}
	/**
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void quitProgram() throws JsonGenerationException, JsonMappingException, IOException, ParseException 
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
	public void editPerson(int index) throws JsonGenerationException, JsonMappingException, IOException, ParseException 
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
			storage.getBook().get(index).setAddress(newAddress);
			Utility.convertJavaToJson(storage, filePath);
			addressBookManager.showOptions();
			break;
		case 2:
			System.out.println("Enter the new city name");
			String newCity=Utility.retNext();
			storage.getBook().get(index).setAddress(newCity);
			Utility.convertJavaToJson(storage, filePath);
			addressBookManager.showOptions();
			break;
		case 3:
			System.out.println("Enter the new state name");
			String newState=Utility.retNext();
			storage.getBook().get(index).setAddress(newState);
			Utility.convertJavaToJson(storage, filePath);
			addressBookManager.showOptions();
			break;
		case 4:
			System.out.println("Enter the new zip code");
			String newZipCode=Utility.retNext();
			storage.getBook().get(index).setAddress(newZipCode);
			Utility.convertJavaToJson(storage, filePath);
			addressBookManager.showOptions();
			break;
		case 5:
			System.out.println("Enter the new Phone number");
			String newPhoneNum=Utility.retNext();
			storage.getBook().get(index).setAddress(newPhoneNum);
			Utility.convertJavaToJson(storage, filePath);
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
	public void removePerson(int removeIndex) throws JsonGenerationException, JsonMappingException, IOException, ParseException 
	{
		storage.getBook().remove(storage.getBook().get(removeIndex));
		Utility.convertJavaToJson(storage, filePath);
		addressBookManager.showOptions();
	}

	public void sortByName() throws JsonGenerationException, JsonMappingException, IOException, ParseException 
	{
		String[] names=new String[storage.getBook().size()];
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
		addressBookManager.showOptions();
	}

	/**
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ParseException 
	 */
	public void sortByZipCode() throws JsonGenerationException, JsonMappingException, IOException, ParseException 
	{
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
		}
		Utility.convertJavaToJson(storage, filePath);
		addressBookManager.showOptions();
	}

	public void createNewAddressBook() 
	{
		String fileName="Untitled";
		
	}

	
}
