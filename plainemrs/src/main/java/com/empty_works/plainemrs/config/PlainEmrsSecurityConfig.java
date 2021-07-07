package com.empty_works.plainemrs.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class PlainEmrsSecurityConfig extends WebSecurityConfigurerAdapter {

	// Add reference to security data source
	
	//@Autowired
	//private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/*
		// Use JDBC authentication
		auth.jdbcAuthentication().dataSource(securityDataSource);
		*/
		
		// Add users for in-memor authentication
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("charity").password("love123").roles("ADMIN", "AUTHORIZED"))
			.withUser(users.username("endure").password("love123").roles("ALLIED_MEDICAL_STAFF", "AUTHORIZED"))
			.withUser(users.username("schmoe").password("love123").roles("AUTHORIZED"));
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/").hasRole("AUTHORIZED")
			.antMatchers("/systems/**").hasRole("ADMIN")
			.antMatchers("/medical-staff/**").hasAnyRole("DOCTOR", "NURSE")
			.antMatchers("/allied-staff/**").hasRole("ALLIED_MEDICAL_STAFF")
			.antMatchers("/non-employees/**").hasAnyRole("PROVIDER", "GOVERNMENT", "FACILITY")
			.and()
			.formLogin()
				.loginPage("/show-login-page") // show custom form at the request mapping "/show-login-page"
				.loginProcessingUrl("/authenticate-the-user") // login form should POST data to this URL for processing 
															// (check user id and password)
				.permitAll()// allow everyone to see login page. No need to be logged in.
			.and()
			.logout().permitAll();
			//.and()
			//.exceptionHandling().accessDeniedPage("/access-denied");
	}
}
