/**
 * 
 */
package com.bridgelabz.service;

import java.util.ArrayList;

import com.bridgelabz.model.Doctor;

public interface DoctorService 
{
	public Doctor searchDoctorByName();
	
	public Doctor searchDoctorById();
	
	public ArrayList<Doctor> searchDoctorBySpecialization();
	
	public ArrayList<Doctor> searchDoctorByAvailability();
	
}
