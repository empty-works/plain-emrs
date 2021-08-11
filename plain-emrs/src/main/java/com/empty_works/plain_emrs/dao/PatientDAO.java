package com.empty_works.plain_emrs.dao;

import java.util.List;

import com.empty_works.plain_emrs.entity.Patient;

public interface PatientDAO {

	public List<Patient> getPatients();
	
	public void savePatient(Patient thePatient);
	
	public Patient getPatient(int theId);
	
	public void deletePatient(int theId);
}
