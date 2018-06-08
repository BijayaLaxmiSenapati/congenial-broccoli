/**
 * 
 */
package com.bridgelabz.objectorientedprograms;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

/**
 * @author adminstrato
 *
 */
public class AddressBook1
{
	private ArrayList<Person> persons=new ArrayList<>();                                                                            
	
	public ArrayList<Person> getPersons() {
		return persons;
	}

	public void setPersons(ArrayList<Person> persons) {
		this.persons = persons;
	}
	

	AddressBook1(String filePath)
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
}
