package top.kwp8.utils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InitServletContext implements ServletContextListener {

	private  final Logger logger = LoggerFactory.getLogger(getClass());
	private ServletContext servletContext;
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		servletContext.removeAttribute("base");
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		 servletContext = servletContextEvent.getServletContext();
		 String base = servletContext.getContextPath();
		 logger.info("base: "+base);
		 servletContext.setAttribute("base", base);
	}

}
