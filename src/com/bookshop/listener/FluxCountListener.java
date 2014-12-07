package com.bookshop.listener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.bookshop.factory.ConnectionFactory;

/**
 * Application Lifecycle Listener implementation class FluxCountListener
 *
 */
@WebListener
public class FluxCountListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public FluxCountListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    	System.out.println("服务器启动");
    
        ServletContext application = (ServletContext) arg0.getServletContext();
    
        try {
        	Connection cn = ConnectionFactory.getConnection();
            String sql="select * from fluxtbl";
          	 PreparedStatement ps=cn.prepareStatement(sql);
        	 ResultSet rs=ps.executeQuery();
			if(rs.next()){
				Integer flux=Integer.parseInt(rs.getString(1));
				application.setAttribute("flux", flux);
				System.out.println("数据已取得");
			}
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
        
      
    }
    

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    	  ServletContext application = (ServletContext) arg0.getServletContext();
          Integer flux=(Integer) application.getAttribute("flux");
          String sql="update fluxtbl set flux="+flux+"";
          Connection cn=null;
          try{
            cn = ConnectionFactory.getConnection();
        	PreparedStatement ps=cn.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
  			
  		}catch(Exception e){
  			System.out.println("数据取得失败");
  		}
          try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
