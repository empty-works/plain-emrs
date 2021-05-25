package com.empty_works.plainemrs.conf;

import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.empty_works.plainemrs")
//@PropertySource("classpath:persistence-mysql.properties")
public class PlainEmrsAppConfig {
	
	// Set up variable to hold the properties
	@Autowired
	private Environment env; // Will hold data read from properties files
							 // Spring helper to hold the properties
	
	// Set up a logger for diagnostics
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// Define a bean for ViewResolver
	@Bean
	public ViewResolver resolveView() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	// Define a bean for a security data source
	//@Bean
	//public DataSource getSecurityDataSource() {
		
	//}
}