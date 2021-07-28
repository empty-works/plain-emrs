package com.empty_works.plain_emrs.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity
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
			.antMatchers("/").hasRole("AUTHORIZED")
			.antMatchers("/systems/**").hasRole("ADMIN")
			.antMatchers("/medical-staff/**").hasAnyRole("DOCTOR", "NURSE")
			.antMatchers("/allied-staff/**").hasRole("ALLIED_MEDICAL_STAFF")
			.antMatchers("/non-employees/**").hasAnyRole("PROVIDER", "GOVERNMENT", "FACILITY")
			.and()
			.formLogin()
				.loginPage("/show-login-page") // show custom form at the request mapping "/showMyLoginPage"
				.loginProcessingUrl("/authenticate-the-user") // login form should POST data to this URL for processing (check user id and password)
				.permitAll()// allow everyone to see login page. No need to be logged in.
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
	}

	@Bean
	public UserDetailsManager userDetailsManager() {
		
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
		
		jdbcUserDetailsManager.setDataSource(securityDataSource);
		
		return jdbcUserDetailsManager; 
	}
}
