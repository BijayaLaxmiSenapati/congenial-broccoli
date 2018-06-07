/**
 * 
 */
package com.bridgelabz.objectorientedprograms;

import java.util.ArrayList;

import org.codehaus.jackson.io.UTF32Reader;

import com.bridgelabz.utility.Utility;

public class AddressBookApplication {

	public static void main(String[] args) 
	{
		
		AddressBook addressBook=new AddressBook();
		System.out.println("Choose one of the options given");
		System.out.println("1.CREATE NEW ADDRESSBOOK\t\t 2.OPEN ADDRESS BOOK\t\t");
		System.out.println("3.VIEW ALL ADDRESS BOOK\t\t 4.DELETE ADDRESS BOOK\t\t 5.EXIT");
		int choice=Utility.retInt();
		switch(choice)
		{
		case 1:
			addressBook.createNewAddressBook();
			break;
		case 2:
			addressBook.viewAllAddressBook();
			System.out.println("enter index of the address book which you want to open");
			int indexOfFileList=Utility.retInt();
			addressBook.openAddressBook(indexOfFileList);
			break;
		case 3:
			addressBook.viewAllAddressBook();
			break;
		case 4:
			addressBook.viewAllAddressBook();
			System.out.println("enter index of the address book which you want to delete");
			int indexOfFileListToDelete=Utility.retInt();
			addressBook.deleteAddressBook();
			break;
		case 5:
			addressBook.quitProgram();
			break;
		default:
		}
	}

}
