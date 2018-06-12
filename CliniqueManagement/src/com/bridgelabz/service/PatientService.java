/**
 * 
 */
package com.bridgelabz.service;

import com.bridgelabz.model.Patient;

public interface PatientService 
{
	public Patient searchPatientByName();
	
	public Patient searchPatientByMobileNumber();
	
	public Patient searchPatientById();
	
	public void takeAppointment();
	
	public void showPatientDetails();
	
	public void showPopularDoctor();
	
	public void showPopularSpecialization();
	
}
