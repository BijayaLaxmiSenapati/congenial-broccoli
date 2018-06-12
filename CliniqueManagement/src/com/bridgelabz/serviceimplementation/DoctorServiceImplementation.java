/**
 * 
 */
package com.bridgelabz.serviceimplementation;

import java.util.ArrayList;

import com.bridgelabz.controller.CliniqueManager;
import com.bridgelabz.model.Doctor;
import com.bridgelabz.service.DoctorService;
import com.bridgelabz.utility.Utility;

public class DoctorServiceImplementation implements DoctorService
{
	static ArrayList<Doctor> doctorsList=new ArrayList<Doctor>();
	
	public DoctorServiceImplementation(String doctorsfile) 
	{
		doctorsList=Utility.convertJsonToListUsingJackson(doctorsfile, Doctor.class);
	}

	public DoctorServiceImplementation() 
	{
		
	}
	
	
	public void searchDoctor() 
	{

		System.out.println("select the option by which you want to search a doctor");
		System.out.println("1. by name \t\t 2.by id \t\t 3.by specialization \t\t 4.by availability");
		int option=Utility.retInt();
		switch(option)
		{
		case 1:
			System.out.println(searchDoctorByName());
			break;
		case 2:
			System.out.println(searchDoctorById());
			break;
		case 3:
			ArrayList<Doctor> sameSpecializationList=searchDoctorBySpecialization();
			for(int i=0;i<sameSpecializationList.size();i++)
			{
				System.out.println(sameSpecializationList.get(i));
			}
			break;
		case 4:
			ArrayList<Doctor> sameAvailabilityList=searchDoctorByAvailability();
			for(int i=0;i<sameAvailabilityList.size();i++)
			{
				System.out.println(sameAvailabilityList.get(i));
			}
			break;
		default:
			System.out.println("wrong option selected");
		}
		CliniqueManager.showOptions();
		
	}
	@Override
	public Doctor searchDoctorByName() 
	{
		System.out.println("enter name of the doctor whom you want to search");
		String nameToSearch=Utility.retNext();
		for(int i=0;i<doctorsList.size();i++)
		{
			if(doctorsList.get(i).getDoctorName().equals(nameToSearch))
			{
				return doctorsList.get(i);
			}
		}
		return null;
		
		
	}

	@Override
	public Doctor searchDoctorById()
	{
		System.out.println("enter id of the doctor whom you want to search");
		long idToSearch=Utility.retLong();
		for(int i=0;i<doctorsList.size();i++)
		{
			if(doctorsList.get(i).getDoctorId()==idToSearch)
			{
				return doctorsList.get(i);
			}
		}
		return null;
		
	}

	@Override
	public ArrayList<Doctor> searchDoctorBySpecialization() 
	{
		ArrayList<Doctor> sameSpecializationList=new ArrayList<Doctor>();
		System.out.println("enter specialization of the doctor whom you want to search");
		String specializationToSearch=Utility.retNext();
		for(int i=0;i<doctorsList.size();i++)
		{
			if(doctorsList.get(i).getSpecialization().equals(specializationToSearch))
			{
				sameSpecializationList.add(doctorsList.get(i));
			}
		}
		return sameSpecializationList;
		
	}

	@Override
	public ArrayList<Doctor> searchDoctorByAvailability()
	{
		ArrayList<Doctor> sameAvailabilityList=new ArrayList<Doctor>();
		System.out.println("enter availability of the doctor whom you want to search");
		String availabilityToSearch=Utility.retNext();
		for(int i=0;i<doctorsList.size();i++)
		{
			if(doctorsList.get(i).getAvailability().equals(availabilityToSearch))
			{
				sameAvailabilityList.add(doctorsList.get(i));
			}
		}
		return sameAvailabilityList;
		
	}



}
