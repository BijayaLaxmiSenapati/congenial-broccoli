/**
 * 
 */
package com.bridgelabz.model;

public class Appointment 
{
	private String patientName;
	private long patientId;
	private String doctorName;
	private long doctorId;
	//timeStamp;
	public String getPatientName() 
	{
		return patientName;
	}
	public void setPatientName(String patientName) 
	{
		this.patientName = patientName;
	}
	public long getPatientId() 
	{
		return patientId;
	}
	public void setPatientId(long patientId)
	{
		this.patientId = patientId;
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
		return doctorId;
	}
	public void setDoctorId(long doctorId) 
	{
		this.doctorId = doctorId;
	}
}
