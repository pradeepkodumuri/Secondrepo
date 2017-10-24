package com.tek.demo.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebServletConfiguration extends AbstractAnnotationConfigDispatcherServletInitializer {



	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("in initializer");
		return new Class[] {SpringConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };

	}
}
