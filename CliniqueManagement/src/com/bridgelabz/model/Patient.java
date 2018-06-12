/**
 * 
 */
package com.bridgelabz.model;

public class Patient 
{
	private String patientName;
	private long patientId;
	private long patientMobileNumber;
	private long patientAge;
	public String getPatientName() 
	{
		return patientName;
	}
	public void setPatientName(String name) 
	{
		this.patientName = name;
	}
	public long getPatientId() 
	{
		return patientId;
	}
	public void setPatientId(long id)
	{
		this.patientId = id;
	}
	public long getPatientMobileNumber() 
	{
		return patientMobileNumber;
	}
	public void setPatientMobileNumber(long mobileNumber)
	{
		this.patientMobileNumber = mobileNumber;
	}
	public long getPatientAge() 
	{
		return patientAge;
	}
	public void setPatientAge(long age)
	{
		this.patientAge = age;
	}
	@Override
	public String toString() {
		return "Patient [patientName=" + patientName + ", patientId=" + patientId + ", patientMobileNumber="
				+ patientMobileNumber + ", patientAge=" + patientAge + "]";
	}
	

}
