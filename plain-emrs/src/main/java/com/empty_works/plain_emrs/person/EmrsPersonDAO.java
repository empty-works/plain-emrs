package com.empty_works.plain_emrs.person;

import java.util.List;

public interface EmrsPersonDAO {

	public List<EmrsPerson> getPeople();
	
	public void savePerson(EmrsPerson thePerson);
	
	public EmrsPerson getPerson(int theId);
	
	public void deletePerson(int theId);
}
