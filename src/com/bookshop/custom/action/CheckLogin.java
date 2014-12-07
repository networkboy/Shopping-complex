package com.bookshop.custom.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.bookshop.business.MycartBusiness;
import com.bookshop.value.CustomValue;

/**
 * Servlet implementation class CheckLogin
 */
@WebServlet("/Login/CheckLogin.do")
public class CheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomValue cv = (CustomValue)request.getSession().getAttribute("userInfo");
		if(cv==null){
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			
			//用户登录数量
			
			request.getSession().setAttribute("userInfo", cv);
				
				//2.把购物车的信息取出，准备下一个页面显示
	            MycartBusiness mb=(MycartBusiness)request.getSession().getAttribute("mycart") ;
				
				ArrayList al=mb.showMyCart();
				request.setAttribute("mycartInfo", al);
//				HttpSession session=request.getSession(true);
//				session=request.getSession(true);
//				session.setAttribute("user", 1);
			request.getRequestDispatcher("loginsucess.jsp").forward(request, response);
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
