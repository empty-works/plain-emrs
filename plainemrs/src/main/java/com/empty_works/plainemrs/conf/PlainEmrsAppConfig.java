package com.empty_works.plainemrs.conf;

import java.beans.PropertyVetoException;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.empty_works.plainemrs")
//@PropertySource("classpath:persistence-mysql.properties")
public class PlainEmrsAppConfig {
	
}