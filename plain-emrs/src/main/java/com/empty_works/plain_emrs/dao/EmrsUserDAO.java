package com.empty_works.plain_emrs.dao;

import java.util.List;

import com.empty_works.plain_emrs.entity.EmrsUser;

public interface EmrsUserDAO {


	public List<EmrsUser> getEmrsUsers();
	
	public void saveEmrsUser(EmrsUser theEmrsUser);
	
	public EmrsUser getEmrsUser(String username);
	
	public void deletePatient(String username);
}
