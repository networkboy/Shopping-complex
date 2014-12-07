package com.bookshop.good.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookshop.business.GoodBusiness;
import com.bookshop.factory.BusinessFactory;
import com.bookshop.value.GoodValue;

/**
 * Servlet implementation class Showdetail
 */
@WebServlet("/Showbook/Showdetail.do")
public class Showdetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext application;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Showdetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		long goodsId = 0;
		goodsId=Long.parseLong(id);
		GoodValue gv = new GoodValue();
		
		try{
			   GoodBusiness gb = BusinessFactory.showdetail();
			   gv.setGoodsId(goodsId);
			   gb.showdetail(gv);
			   request.setAttribute("gv", gv);
			 
			 
			   request.getRequestDispatcher("../Showbook/showbook.jsp").forward(request, response);
		}catch(Exception e){
			System.out.println("´íÎó"+e.getMessage());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
