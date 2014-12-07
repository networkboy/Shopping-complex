package com.bookshop.custom.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class show
 */
@WebServlet("/show.action")
public class show extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private java.sql.Connection cn=null;   
	  public void init()throws ServletException
	    {
	    
	    }
			

			
    public show() {
        super();
        // TODO Auto-generated constructor stub
    }
		
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubre
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
	    String id=request.getParameter("name");
		out.print("<h1>"+id+"</h1>");
		
		out.print("<img src='customphoto.action?id="+id+"'>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
