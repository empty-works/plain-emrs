package com.empty_works.plain_emrs.person;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmrsPersonDAOImpl implements EmrsPersonDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<EmrsPerson> getPeople() {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<EmrsPerson> theQuery = currentSession.createQuery(
				"from Person order by last_name", EmrsPerson.class);
		
		List<EmrsPerson> people = theQuery.getResultList();
		
		return people;
	}

	@Override
	public void savePerson(EmrsPerson thePerson) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(thePerson);
	}

	@Override
	public EmrsPerson getPerson(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		EmrsPerson thePerson = currentSession.get(EmrsPerson.class, theId);
		
		return thePerson;
	}

	@Override
	public void deletePerson(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from people where id=:person_id");
		theQuery.setParameter("person_id", theId);
		
		theQuery.executeUpdate();
	}

}
