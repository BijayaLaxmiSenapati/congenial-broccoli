/**
 * 
 */
package com.bridgelabz.serviceimplementation;

import java.util.ArrayList;

import com.bridgelabz.controller.CliniqueManager;
import com.bridgelabz.model.Appointment;
import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;
import com.bridgelabz.service.ManagerService;
import com.bridgelabz.utility.Utility;

public class ManagerServiceImplementation implements ManagerService
{
	Doctor doctor=null;
	Patient patient=null;
	static ArrayList<Appointment> appointmentList=new ArrayList<Appointment>();
	
	public ManagerServiceImplementation(String appointmentfile) 
	{
		appointmentList=Utility.convertJsonToListUsingJackson(appointmentfile, Appointment.class);
	}

	public ManagerServiceImplementation() 
	{
		
	}
	@Override
	public void addDoctor() 
	{
		doctor=new Doctor();
		System.out.println("Enter Doctors name");
		String doctorName=Utility.retNext();
		doctor.setDoctorName(doctorName);
		//System.out.println("Enter Doctors ID");
		long doctorId=Utility.randomNumberInRange(0,100);
		if(DoctorServiceImplementation.doctorsList==null)
		{
			doctor.setDoctorId(doctorId);
		}
		else
		{
			for(int i=0;i<DoctorServiceImplementation.doctorsList.size();i++)
			{
				if(doctorId==DoctorServiceImplementation.doctorsList.get(i).getDoctorId())
				{
					doctorId=Utility.randomNumberInRange(0, 100);
					continue;
				}
			}
			doctor.setDoctorId(doctorId);
		}
		//doctor.setDoctorId(doctorId);
		System.out.println("Enter Doctors specialization");
		String specialization=Utility.retNext();
		doctor.setSpecialization(specialization);
		System.out.println("Enter Doctors availability. Enter in capital letters");
		System.out.println("Enter \"AM\", \"PM\" or \"BOTH\"");
		String doctorAvailability=Utility.retNext();
		doctor.setAvailability(doctorAvailability);
		DoctorServiceImplementation.doctorsList.add(doctor);
		Utility.convertJavaToJson(DoctorServiceImplementation.doctorsList, CliniqueManager.DOCTORS_FILE);
		CliniqueManager.showOptions();
	}

	@Override
	public void updateDoctorDetails() 
	{
		showDoctorDetails();
		System.out.println("Enter index of the doctor whose details you want to update");
		int indexToUpdate=Utility.retInt();
		System.out.println("enter what do you want to change.");
		System.out.println("1.doctor specialization");
		System.out.println("2.doctor availability");
		int changeOption=Utility.retInt();
		switch(changeOption)
		{
		case 1:
			System.out.println("enter the new specialization");
			String newSpecialization=Utility.retNext();
			DoctorServiceImplementation.doctorsList.get(indexToUpdate).setSpecialization(newSpecialization);
			Utility.convertJavaToJson(DoctorServiceImplementation.doctorsList, CliniqueManager.DOCTORS_FILE);
			break;
		case 2:
			System.out.println("enter the new availability");
			String newAvailability=Utility.retNext();
			DoctorServiceImplementation.doctorsList.get(indexToUpdate).setAvailability(newAvailability);
			Utility.convertJavaToJson(DoctorServiceImplementation.doctorsList, CliniqueManager.DOCTORS_FILE);
			break;
		default:
			System.err.println("wrong option entered");
		}
		showDoctorDetails();
		CliniqueManager.showOptions();
		
	}

	@Override
	public void deleteDoctor()
	{
		showDoctorDetails();
		System.out.println("enter index of the doctor whose details you want to delete");
		int indexToDelete=Utility.retInt();
		DoctorServiceImplementation.doctorsList.remove(indexToDelete);
		Utility.convertJavaToJson(DoctorServiceImplementation.doctorsList, CliniqueManager.DOCTORS_FILE);
		showDoctorDetails();
		CliniqueManager.showOptions();
	}

	
	public void showDoctorDetails()
	{
		for(int i=0;i<DoctorServiceImplementation.doctorsList.size();i++)
		{
			System.out.println("index: "+i+"=");
			System.out.println(DoctorServiceImplementation.doctorsList.get(i));
		}
		//CliniqueManager.showOptions();
	}
	
	/*@Override
	public void addPatient() 
	{
		patient=new Patient();
		System.out.println("enter the patient name");
		String patientName=Utility.retNext();
		patient.setPatientName(patientName);
		long patientId=Utility.randomNumberInRange(0,100);
		for(int i=0;i<PatientServiceImplementation.patientsList.size();i++)
		{
			if(patientId==PatientServiceImplementation.patientsList.get(i).getPatientId())
			{
				patientId=Utility.randomNumberInRange(100, 200);
				continue;
			}
		}
		patient.setPatientId(patientId);
		System.out.println("enter the patient mobile number");
		long patientMobileNumber=Utility.retLong();
		patient.setPatientMobileNumber(patientMobileNumber);
		System.out.println("enter the patient age");
		long patientAge=Utility.retLong();
		patient.setPatientAge(patientAge);
		PatientServiceImplementation.patientsList.add(patient);
		Utility.convertJavaToJson(PatientServiceImplementation.patientsList, CliniqueManager.PATIENTS_FILE);
		CliniqueManager.showOptions();
	}*/
	public Patient addPatient(long patientMobileNumber)
	{
		patient=new Patient();
		patient.setPatientMobileNumber(patientMobileNumber);
		System.out.println("enter the patient name");
		String patientName=Utility.retNext();
		patient.setPatientName(patientName);
		long patientId=Utility.randomNumberInRange(0,100);
		for(int i=0;i<PatientServiceImplementation.patientsList.size();i++)
		{
			if(patientId==PatientServiceImplementation.patientsList.get(i).getPatientId())
			{
				patientId=Utility.randomNumberInRange(100, 200);
				continue;
			}
		}
		patient.setPatientId(patientId);
		System.out.println("enter the patient age");
		long patientAge=Utility.retLong();
		patient.setPatientAge(patientAge);
		PatientServiceImplementation.patientsList.add(patient);
		Utility.convertJavaToJson(PatientServiceImplementation.patientsList, CliniqueManager.PATIENTS_FILE);
		return patient;
	}

	@Override
	public void updatePatientDetails() 
	{
		showPatientDetails();
		System.out.println("Enter index of the patient whose details you want to update");
		int indexToUpdate=Utility.retInt();
		System.out.println("enter what do you want to change.");
		System.out.println("1.patient mobile number");
		System.out.println("2.patient age");
		int changeOption=Utility.retInt();
		switch(changeOption)
		{
		case 1:
			System.out.println("enter the new mobile number");
			long newMobileNumber=Utility.retLong();
			PatientServiceImplementation.patientsList.get(indexToUpdate).setPatientMobileNumber(newMobileNumber);
			Utility.convertJavaToJson(PatientServiceImplementation.patientsList, CliniqueManager.PATIENTS_FILE);
			break;
		case 2:
			System.out.println("enter the new age");
			long newAge=Utility.retLong();
			PatientServiceImplementation.patientsList.get(indexToUpdate).setPatientAge(newAge);
			Utility.convertJavaToJson(PatientServiceImplementation.patientsList, CliniqueManager.PATIENTS_FILE);
			break;
		default:
			System.err.println("wrong option entered");
		}
		CliniqueManager.showOptions();
	}

	@Override
	public void deletePatient()
	{
		showPatientDetails();
		System.out.println("enter index of the patient whose details you want to delete");
		int indexToDelete=Utility.retInt();
		PatientServiceImplementation.patientsList.remove(indexToDelete);
		Utility.convertJavaToJson(PatientServiceImplementation.patientsList, CliniqueManager.PATIENTS_FILE);
		showPatientDetails();
		CliniqueManager.showOptions();
		
	}
	
	
	public void showPatientDetails()
	{
		for(int i=0;i<PatientServiceImplementation.patientsList.size();i++)
		{
			System.out.println("index: "+i+"=");
			System.out.println(PatientServiceImplementation.patientsList.get(i));
		}
		CliniqueManager.showOptions();
	}

}
