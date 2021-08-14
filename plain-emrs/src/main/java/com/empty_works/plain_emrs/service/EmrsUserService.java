package com.empty_works.plain_emrs.service;

import java.util.List;

import com.empty_works.plain_emrs.entity.EmrsUser;

public interface EmrsUserService {

	public List<EmrsUser> getEmrsUser();
	
	public void saveEmrsUser(EmrsUser theEmrsUser);
	
	public EmrsUser getEmrsUser(String username);
	
	public void deleteEmrsUser(String username);
}