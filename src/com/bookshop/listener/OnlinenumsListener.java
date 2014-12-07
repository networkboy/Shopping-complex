package com.bookshop.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class OnlinenumsListener
 *
 */
@WebListener
public class OnlinenumsListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public OnlinenumsListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
        ServletContext application = (ServletContext) arg0.getServletContext();
    	Integer Onlinenums=0;
		application.setAttribute("Onlinenums", Onlinenums);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
