package com.bookshop.custom.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.bookshop.business.CustomBusiness;
import com.bookshop.business.MycartBusiness;
import com.bookshop.factory.BusinessFactory;
import com.bookshop.value.CustomValue;



/**
 * Servlet implementation class Login
 */
@WebServlet("/Login/Login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Mistakes mt=new Mistakes();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		CustomValue cv = new CustomValue();
		
		try{
			   CustomBusiness cb = BusinessFactory.checklogin();
			   cv.setUsername(username);
			   cv.setPasswd(password);
			   cb.checklogin(cv);
	    }catch(Exception e){
		System.out.println("����"+e.getMessage());
	    }
		if(cv.isChecklogin()){
			
			try {
				CustomBusiness cb = BusinessFactory.selectall();
				cv.setUsername(username);
				cb.selectall(cv);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println("����"+e1.getMessage());
			}
            request.getSession().setAttribute("userInfo", cv);
			
		
            MycartBusiness mb=(MycartBusiness)request.getSession().getAttribute("mycart") ;
			
			ArrayList al=mb.showMyCart();
			request.setAttribute("mycartInfo", al);
			
			request.getRequestDispatcher("loginsucess.jsp").forward(request, response);
			
		}else{
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
			
		}
		
	    

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
