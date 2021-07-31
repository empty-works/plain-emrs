package com.empty_works.plain_emrs.user;

import java.util.List;

public interface EmrsUserDAO {

	public List<EmrsUser> getEmrsUsers();
	
	public void saveEmrsUser(EmrsUser theUser);
	
	public EmrsUser getEmrsUser(int theId);
	
	public void deleteEmrsUser(int theId);
}
