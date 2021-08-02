package com.empty_works.plain_emrs.user;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmrsUserDAOImp implements EmrsUserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<EmrsUser> getEmrsUsers() {

		Session currentSession = sessionFactory.getCurrentSession();
		Query<EmrsUser> theQuery = currentSession.createQuery("from users order by username",
				EmrsUser.class);
		
		List<EmrsUser> users = theQuery.getResultList();
		
		return users;
	}

	@Override
	public void saveEmrsUser(EmrsUser theUser) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theUser);
	}

	@Override
	public EmrsUser getEmrsUser(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		EmrsUser theUser = currentSession.get(EmrsUser.class, theId);
		return theUser;
	}

	@Override
	public void deleteEmrsUser(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();

	}
}
