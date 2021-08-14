package com.empty_works.plain_emrs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.empty_works.plain_emrs.dao.EmrsUserDAO;
import com.empty_works.plain_emrs.entity.EmrsUser;

@Service
public class EmrsUserDetailsService implements UserDetailsService {
	
	@Autowired
	EmrsUserDAO emrsUserDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			
		EmrsUser user = emrsUserDAO.getEmrsUser(username);
		if(user == null) {
			throw new UsernameNotFoundException(username + " not found.");
		}
		System.out.println("User found!");
		return user;
	}
}
