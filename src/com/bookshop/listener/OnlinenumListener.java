package com.bookshop.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class OnlinenumListener
 *
 */
@WebListener
public class OnlinenumListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public OnlinenumListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
        ServletContext application = (ServletContext) arg0.getServletContext();
    	Integer Onlinenum=0;
		application.setAttribute("Onlinenum", Onlinenum);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
