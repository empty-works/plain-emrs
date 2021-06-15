package com.empty_works.plainemrs.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class PlainEmrsSpringMvcDispatcherServletInitializer
		extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {PlainEmrsAppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
