package com.bookshop.custom.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.bookshop.business.CustomBusiness;
import com.bookshop.factory.BusinessFactory;
import com.bookshop.value.CustomValue;
import com.jspsmart.upload.*;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register/Register.do")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
     
    }
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String truename=request.getParameter("truename");
		String password=request.getParameter("password");
		String repassword=request.getParameter("repassword");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String postcode=request.getParameter("postcode");
		Pattern p = Pattern.compile("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\\.([a-zA-Z0-9_-])+)+$");
		Matcher m = p.matcher(email);
		boolean b = m.matches();
		CustomValue cv = new CustomValue();
		try{
			   CustomBusiness cb = BusinessFactory.checkusername();
			   cv.setUsername(username);
			   cb.checkusername(cv);
		}catch(Exception e){
			System.out.println("閿欒"+e.getMessage());
			response.sendRedirect("register.jsp");
		}
		if(!password.equals(repassword)){
			cv.setPasserror("密码错误");
			request.setAttribute("cv",cv);
		}
		if(!b){
			cv.setEmailerror("电子邮件错误");
			request.setAttribute("cv",cv);
		}	
		if(cv.isCheckusername()){
			cv.setNameexist("用户已存在");
			request.setAttribute("cv",cv);
		}
		if(!password.equals(repassword)||!b||cv.isCheckusername()){
			RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
			rd.forward(request,response);
		}else{
			try{
				CustomBusiness cb = BusinessFactory.createProductBusiness();
               cv.setUsername(username);
               cv.setTruename(truename);
               cv.setPasswd(password);
			   cv.setEmail(email);
			   cv.setPhone(phone);
			   cv.setAddress(address);
			   cv.setPostcode(postcode);
			   cb.create(cv);
			   response.sendRedirect("../Login/login.jsp");
		}catch(Exception e){
			System.out.println("错误"+e.getMessage());
			response.sendRedirect("register.jsp");
		}
			
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
