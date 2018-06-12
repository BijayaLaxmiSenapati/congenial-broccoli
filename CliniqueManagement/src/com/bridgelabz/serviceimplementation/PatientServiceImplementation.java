/**
 * 
 */
package com.bridgelabz.serviceimplementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

import com.bridgelabz.controller.CliniqueManager;
import com.bridgelabz.model.Appointment;
import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;
import com.bridgelabz.service.PatientService;
import com.bridgelabz.utility.Utility;

public class PatientServiceImplementation implements PatientService
{
	static ArrayList<Patient> patientsList=new ArrayList<Patient>();
	ManagerServiceImplementation managerServiceImplementation=new ManagerServiceImplementation();
	DoctorServiceImplementation doctorServiceImplementation=new DoctorServiceImplementation();
	Appointment appointment=null;
	Doctor doctor=new Doctor();
	Patient patient=new Patient();

	public PatientServiceImplementation(String patientsfile) 
	{
		patientsList=Utility.convertJsonToListUsingJackson(patientsfile, Patient.class);
	}

	public PatientServiceImplementation() 
	{
		
	}

	public void searchPatient()
	{
		System.out.println("select the option by which you want to search a patient");
		System.out.println("1. by name \t\t 2.by mobile number \t\t 3.by ID");
		int option=Utility.retInt();
		switch(option)
		{
		case 1:
			searchPatientByName();
			break;
		case 2:
			searchPatientByMobileNumber();
			break;
		case 3:
			searchPatientById();
			break;
		default:
			System.out.println("wrong option selected");
		}
	}
	@Override
	public Patient searchPatientByName() 
	{
		System.out.println("enter name of the patient whom you want to search");
		String nameToSearch=Utility.retNext();
		for(int i=0;i<patientsList.size();i++)
		{
			if(patientsList.get(i).getPatientName().equals(nameToSearch))
			{
				return patientsList.get(i);
			}
		}
		return null;
		
	}

	@Override
	public Patient searchPatientByMobileNumber()
	{
		System.out.println("enter mobile number of the patient whom you want to search");
		long mobNumToSearch=Utility.retLong();
		for(int i=0;i<patientsList.size();i++)
		{
			if(patientsList.get(i).getPatientMobileNumber()==mobNumToSearch)
			{
				return patientsList.get(i);
			}
		}
		return null;
	}

	@Override
	public Patient searchPatientById() 
	{
		System.out.println("enter id of the patient whom you want to search");
		long idToSearch=Utility.retLong();
		for(int i=0;i<patientsList.size();i++)
		{
			if(patientsList.get(i).getPatientId()==idToSearch)
			{
				return patientsList.get(i);
			}
		}
		return null;
	}

	@Override
	public void takeAppointment() 
	{
		Patient ifPresent=null;
		System.out.println("Enter mobile number of the patient");
		long patientMobileNumber=Utility.retLong();
		for(int i=0;i<patientsList.size();i++)
		{
			if(patientMobileNumber==patientsList.get(i).getPatientMobileNumber())
			{
				ifPresent=patientsList.get(i);
			}
		}
		if(ifPresent==null)
		{
			ifPresent=managerServiceImplementation.addPatient(patientMobileNumber);
		}
		ArrayList<Doctor> selectedSpecialization=doctorServiceImplementation.searchDoctorBySpecialization();
		System.out.println("enter required time");
		String time=Utility.retNext();
		ArrayList<Doctor> selectedSpecializationAndTime=new ArrayList<Doctor>();
		for(int i=0;i<selectedSpecialization.size();i++)
		{
			if(selectedSpecialization.get(i).getAvailability().equals(time)|| selectedSpecialization.get(i).getAvailability().equals("BOTH"))
			{
				selectedSpecializationAndTime.add(selectedSpecialization.get(i));
			}
		}
		if(selectedSpecializationAndTime.size()==0)
		{
			System.out.println("We dont have any doctor with respect to your given specialization and time.. You can come some other day");
		}
		else
		{
			System.out.println("enter id of the doctor to consult with, from the given options:");
			for(int i=0;i<selectedSpecializationAndTime.size();i++)
			{
				System.out.println(selectedSpecializationAndTime.get(i));
			}
			long idOption=Utility.retLong();
			for(int i=0;i<doctorServiceImplementation.doctorsList.size();i++)
			{
				if(doctorServiceImplementation.doctorsList.get(i).getDoctorId()==idOption)
				{
					appointment=new Appointment();
					System.out.println("We appointed "+doctorServiceImplementation.doctorsList.get(i).getDoctorName()+" to "+ifPresent.getPatientName());
					long count=doctorServiceImplementation.doctorsList.get(i).getCountOfPatients()+1;
					if(count<5)
					{
						doctorServiceImplementation.doctorsList.get(i).setCountOfPatients(count);
						Utility.convertJavaToJson(doctorServiceImplementation.doctorsList, CliniqueManager.DOCTORS_FILE);
						appointment.setDoctorName(doctorServiceImplementation.doctorsList.get(i).getDoctorName());
						appointment.setDoctorId(doctorServiceImplementation.doctorsList.get(i).getDoctorId());
						appointment.setPatientName(ifPresent.getPatientName());
						appointment.setPatientId(ifPresent.getPatientId());
						ManagerServiceImplementation.appointmentList.add(appointment);
						Utility.convertJavaToJson(ManagerServiceImplementation.appointmentList, CliniqueManager.APPOINTMENT_FILE);
					}
					else
					{
						System.out.println(doctorServiceImplementation.doctorsList.get(i).getDoctorName()+" doctor is busy with his earlier appointments today. You can come any other day.");
					}
				}
			}
		}
		CliniqueManager.showOptions();
	}

	@Override
	public void showPatientDetails() 
	{
		for(int i=0;i<patientsList.size();i++)
		{
			System.out.println("index: "+i+"=");
			System.out.println(patientsList.get(i));
		}
		
	}

	@Override
	public void showPopularDoctor()
	{
		int[] collectionOfCounts=new int[DoctorServiceImplementation.doctorsList.size()];
		for(int i=0;i<collectionOfCounts.length;i++)
		{
			collectionOfCounts[i]=(int)DoctorServiceImplementation.doctorsList.get(i).getCountOfPatients();
		}
		Arrays.sort(collectionOfCounts);
		long biggestCount=collectionOfCounts[collectionOfCounts.length-1];
		for(int i=0;i<DoctorServiceImplementation.doctorsList.size();i++)
		{
			if(DoctorServiceImplementation.doctorsList.get(i).getCountOfPatients()==biggestCount)
			{
				System.out.println("Most popular doctor:");
				System.out.println(DoctorServiceImplementation.doctorsList.get(i));
				//return;
			}
		}
		
	}

	@Override
	public void showPopularSpecialization()
	{
		TreeSet<String> typesOfSpecialization=new TreeSet<String>();
		int count=0;
		int[] countOfParticularSpecializations=new int[typesOfSpecialization.size()];
		for(int i=0;i<doctorServiceImplementation.doctorsList.size();i++)
		{
			typesOfSpecialization.add(doctorServiceImplementation.doctorsList.get(i).getSpecialization());
		}
		ArrayList<String> typesOfSpecializationDupl=new ArrayList<String>(typesOfSpecialization);
		for(int i=0;i<typesOfSpecializationDupl.size();i++)
		{
			for(int j=0;j<doctorServiceImplementation.doctorsList.size();j++)
			{
				if(doctorServiceImplementation.doctorsList.get(j).getSpecialization().equals(typesOfSpecializationDupl.get(i)))
				{
					count++;
				}
			}
			countOfParticularSpecializations[i]=count;
			count=0;
		}
		Arrays.sort(countOfParticularSpecializations);
		System.out.println("Popular Specialization is:");
		System.out.println(countOfParticularSpecializations[typesOfSpecializationDupl.size()]);
	}

}
