package com.empty_works.plain_emrs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.empty_works.plain_emrs.entity.Patient;

@Repository
public class PatientDAOImpl implements PatientDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Patient> getPatients() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Patient> theQuery = currentSession.createQuery("from patients order by last_name", 
				Patient.class);
		List<Patient> patients = theQuery.getResultList();
		return patients;
	}

	@Override
	public void savePatient(Patient thePatient) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(thePatient);
	}

	@Override
	public Patient getPatient(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Patient.class, theId);
	}

	@Override
	public void deletePatient(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Patient> theQuery = currentSession.createQuery("delete from patients where id=:patient_id", 
				Patient.class);
		theQuery.setParameter("patient_id", theId);
		theQuery.executeUpdate();
	}
}
