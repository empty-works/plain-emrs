package com.empty_works.plain_emrs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empty_works.plain_emrs.dao.PatientDAO;
import com.empty_works.plain_emrs.entity.Patient;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private PatientDAO patientDAO;

	@Override
	@Transactional
	public List<Patient> getPatients() {
		
		return patientDAO.getPatients();
	}

	@Override
	@Transactional
	public void savePatient(Patient thePatient) {
	
		patientDAO.savePatient(thePatient);
	}

	@Override
	@Transactional
	public Patient getPatient(int theId) {

		return patientDAO.getPatient(theId);
	}

	@Override
	@Transactional
	public void deletePatient(int theId) {
		
		patientDAO.deletePatient(theId);
	}
}
