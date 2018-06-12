/**
 * 
 */
package com.bridgelabz.service;

import com.bridgelabz.model.Patient;

public interface ManagerService 
{
	public void addDoctor();
	
	public void updateDoctorDetails();
	
	public void deleteDoctor();
	
	public Patient addPatient(long patientMobileNumber);
	
	public void updatePatientDetails();
	
	public void deletePatient();
	
}
