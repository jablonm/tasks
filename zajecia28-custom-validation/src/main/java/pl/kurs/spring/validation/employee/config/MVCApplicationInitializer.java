package pl.kurs.spring.validation.employee.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MVCApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	protected java.lang.Class<?>[] getRootConfigClasses() {
		return new Class[] { MVCApplicationConfiguration.class };
	}
}
