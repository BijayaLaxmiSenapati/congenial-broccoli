/**
 * 
 */
package com.bridgelabz.model;

public class Doctor 
{
	private String doctorName;
	private long DoctorId;
	private String specialization;
	private String availability;
	private long countOfPatients;
	
	public long getCountOfPatients() {
		return countOfPatients;
	}
	public void setCountOfPatients(long countOfPatients) {
		this.countOfPatients = countOfPatients;
	}
	public String getDoctorName() 
	{
		return doctorName;
	}
	public void setDoctorName(String doctorName) 
	{
		this.doctorName = doctorName;
	}
	public long getDoctorId() 
	{
		return DoctorId;
	}
	public void setDoctorId(long doctorId) 
	{
		DoctorId = doctorId;
	}
	public String getSpecialization() 
	{
		return specialization;
	}
	public void setSpecialization(String specialization)
	{
		this.specialization = specialization;
	}
	public String getAvailability() 
	{
		return availability;
	}
	public void setAvailability(String availability) 
	{
		this.availability = availability;
	}
	@Override
	public String toString() {
		return "Doctor [doctorName=" + doctorName + ", DoctorId=" + DoctorId + ", specialization=" + specialization
				+ ", availability=" + availability + ", countOfPatients=" + countOfPatients + "]";
	}
}
