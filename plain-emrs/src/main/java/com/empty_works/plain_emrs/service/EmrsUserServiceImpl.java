package com.empty_works.plain_emrs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empty_works.plain_emrs.dao.EmrsUserDAO;
import com.empty_works.plain_emrs.entity.EmrsUser;

@Service
public class EmrsUserServiceImpl implements EmrsUserService {
	
	@Autowired
	private EmrsUserDAO emrsUserDAO;

	@Override
	@Transactional
	public List<EmrsUser> getEmrsUser() {
		return emrsUserDAO.getEmrsUsers();
	}

	@Override
	@Transactional
	public void saveEmrsUser(EmrsUser theEmrsUser) {
		emrsUserDAO.saveEmrsUser(theEmrsUser);
	}

	@Override
	@Transactional
	public EmrsUser getEmrsUser(String username) {
		return emrsUserDAO.getEmrsUser(username);
	}

	@Override
	@Transactional
	public void deleteEmrsUser(String username) {
		emrsUserDAO.deletePatient(username);
	}
}
