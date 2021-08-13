package com.empty_works.plain_emrs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.empty_works.plain_emrs.entity.EmrsUser;

@Repository
public class EmrsUserDAOImpl implements EmrsUserDAO {

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
	public void saveEmrsUser(EmrsUser theEmrsUser) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theEmrsUser);
	}

	@Override
	public EmrsUser getEmrsUser(String username) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(EmrsUser.class, "username");
	}

	@Override
	public void deletePatient(String username) {

		Session currentSession = sessionFactory.getCurrentSession();
		Query<EmrsUser> theQuery = currentSession.createQuery("delete from users where id=:username", 
				EmrsUser.class);
		theQuery.setParameter("username", username);
		theQuery.executeUpdate();
	}

}
