/**
 * 
 */
package com.bridgelabz.controller;

import com.bridgelabz.service.DoctorService;
import com.bridgelabz.service.ManagerService;
import com.bridgelabz.service.PatientService;
import com.bridgelabz.serviceimplementation.DoctorServiceImplementation;
import com.bridgelabz.serviceimplementation.ManagerServiceImplementation;
import com.bridgelabz.serviceimplementation.PatientServiceImplementation;
import com.bridgelabz.utility.Utility;

public class CliniqueManager 
{
	public static final String DOCTORS_FILE="/home/adminstrato/BijayaWorkSpace/CliniqueManagement/"
									+ "src/com/bridgelabz/files/Doctor.json";
	public static final String PATIENTS_FILE="/home/adminstrato/BijayaWorkSpace/"
									+ "CliniqueManagement/src/com/bridgelabz/files/Patient.json";
	public static final String APPOINTMENT_FILE="/home/adminstrato/BijayaWorkSpace"
										+ "/CliniqueManagement/src/com/bridgelabz/files/Appointment.json";
	static ManagerServiceImplementation managerService=new ManagerServiceImplementation(APPOINTMENT_FILE);
	static DoctorServiceImplementation doctorService=new DoctorServiceImplementation(DOCTORS_FILE);
	static PatientServiceImplementation patientService=new PatientServiceImplementation(PATIENTS_FILE);
	public static void main(String[] args)
	{
		showOptions();
	}
	
	public static void showOptions()
	{
		System.out.println("select any option:");
		System.out.println("1.add a doctor \t\t\t 2.Update doctor details");
		System.out.println("3.delete a doctor \t\t 4.take appointment");
		System.out.println("5.Update patient details \t 6.delete a patient");
		System.out.println("7.search a doctor \t\t 8.search a patient");
		System.out.println("9.show doctors details \t\t 10.show patient details");
		System.out.println("11.show popular doctor \t\t 12.show popular specialization");
		int option=Utility.retInt();
		doSelectedOption(option);
	}

	private static void doSelectedOption(int option) 
	{
		ManagerServiceImplementation managerServiceImplementation=new ManagerServiceImplementation();
		PatientServiceImplementation patientServiceImplementation=new PatientServiceImplementation();
		DoctorServiceImplementation doctorServiceImplementation=new DoctorServiceImplementation();
		switch(option)
		{
		case 1:
			managerServiceImplementation.addDoctor();
			break;
		case 2:
			managerServiceImplementation.updateDoctorDetails();
			break;
		case 3:
			managerServiceImplementation.deleteDoctor();
			break;
		case 4:
			patientServiceImplementation.takeAppointment();
			break;
		case 5:
			managerServiceImplementation.updatePatientDetails();
			break;
		case 6:
			managerServiceImplementation.deletePatient();
			break;
		case 7:
			doctorServiceImplementation.searchDoctor();
			break;
		case 8:
			patientServiceImplementation.searchPatient();
			break;
		case 9:
			managerServiceImplementation.showDoctorDetails();
			break;
		case 10:
			managerServiceImplementation.showPatientDetails();
			break;
		case 11:
			patientServiceImplementation.showPopularDoctor();
			break;
		case 12:
			patientServiceImplementation.showPopularSpecialization();
			break;
		}
		
	}
}
