package com.bookshop.custom.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookshop.business.CustomBusiness;
import com.bookshop.factory.BusinessFactory;
import com.bookshop.value.CustomValue;

/**
 * Servlet implementation class Altermessage
 */
@WebServlet("/altermessage/Altermessage.do")
public class Altermessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Altermessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		response.setContentType("text/html;charset=utf-8");
		response. setCharacterEncoding("UTF-8");
		CustomValue cv = (CustomValue)request.getSession().getAttribute("userInfo");
		String truename=request.getParameter("truename");
		truename=new String(truename.getBytes(), "utf-8");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String postcode=request.getParameter("postcode");
		System.out.println("truename"+truename);
		try{
			   CustomBusiness cb = BusinessFactory.update();
			   cv.setUsername(cv.getUsername());
               cv.setTruename(truename);
			   cv.setEmail(email);
			   cv.setPhone(phone);
			   cv.setAddress(address);
			   cv.setPostcode(postcode);
			   cb.update(cv);
			   request.getRequestDispatcher("../Login/login.jsp").forward(request, response);
		}catch(Exception e){
			System.out.println("´íÎó"+e.getMessage());
			
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
