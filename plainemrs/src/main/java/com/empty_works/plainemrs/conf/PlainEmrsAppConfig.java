package com.empty_works.plainemrs.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.empty_works.plainemrs")
//@PropertySource("classpath:persistence-mysql.properties")
public class PlainEmrsAppConfig {
	
}