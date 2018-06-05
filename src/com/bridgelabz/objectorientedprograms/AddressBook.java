/**
 * 
 */
package com.bridgelabz.objectorientedprograms;

import java.util.ArrayList;

import com.bridgelabz.utility.Utility;

public class AddressBook 
{
	private static ArrayList<Person> book=new ArrayList<>();

	public ArrayList<Person> getBook() {
		return book;
	}

	public void setBook(ArrayList<Person> book) {
		this.book = book;
	}
	static ArrayList<String> personFirstNames=new ArrayList<>();

	public Person addPerson() 
	{
		String firstName="";
		Person person=new Person();
		System.out.println("for adding person details to the address book");
		System.out.println("Enter the \"First Name\"");
		firstName=Utility.retNext();
		person.setFirstName(firstName);
		personFirstNames.add(firstName);
		System.out.println("Enter the \"Last Name\"");
		person.setLastName(Utility.retNext());
		System.out.println("Enter the \"City\"");
		person.setCity(Utility.retNext());
		System.out.println("Enter the \"State\"");
		person.setState(Utility.retNext());
		System.out.println("Enter the \"Zip Code\"");
		person.setZip(Utility.retNext());
		System.out.println("Enter the \"Phone Number\"");
		person.setPhoneNumber(Utility.retNext());
	
		return person;
	}
	
	public static void showPersonFirstNames()
	{
		for(int i=0;i<personFirstNames.size();i++)
		{
			System.out.println(personFirstNames.get(i));
		}
	}

	
}
