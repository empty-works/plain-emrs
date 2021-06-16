package com.empty_works.plainemrs.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class PlainEmrsSecurityConfig extends WebSecurityConfigurerAdapter {

	// Add reference to security data source
	
	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// Use JDBC authentication
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/").hasRole("NON_MEDICAL_STAFF")
			.antMatchers("/systems/**").hasRole("ADMIN")
			.antMatchers("/medical-staff/**").hasAnyRole("DOCTOR", "NURSE")
			.antMatchers("/allied-staff/**").hasRole("ALLIED_MEDICAL_STAFF")
			.antMatchers("/non-employees/**").hasAnyRole("PROVIDER", "GOVERNMENT")
			.and()
			.formLogin()
				.loginPage("/showMyLoginPage") // show custom form at the request mapping "/showMyLoginPage"
				.loginProcessingUrl("/authenticateTheUser") // login form should POST data to this URL for processing 
															// (check user id and password)
				.permitAll()// allow everyone to see login page. No need to be logged in.
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
	}
}