package com.bookshop.good.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookshop.business.MycartBusiness;


/**
 * Servlet implementation class ShopingDeal
 */
@WebServlet("/Showcart/ShopingDeal.do")
public class ShopingDeal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopingDeal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type=request.getParameter("type");
		MycartBusiness mb= (MycartBusiness)request.getSession().getAttribute("mycart");
		if(mb==null){
			mb=new MycartBusiness();
		    request.getSession().setAttribute("mycart", mb);	
		}
		
		if(type.equals("addGoods")){
		String goodsId=request.getParameter("goodsId");
		
		mb.addGoods(goodsId, "1");
	 
		
		}else if(type.equals("delGoods")){
			String goodsId=request.getParameter("goodsId");
			mb.delGoods(goodsId);
			
		}else if(type.equals("show")){
			
		}else if(type.equals("delAll")){
			mb.clear();
		}else if(type.equals("updateGoods")){
			//mb.upGoods(goodsId, newNum);
			String goodsId[] =request.getParameterValues("goodsId");
			String newNums[] =request.getParameterValues("newNums");
			for(int i=0;i<goodsId.length;i++){
				System.out.println("id"+goodsId[i]+"num"+newNums[i]);
				mb.upGoods(goodsId[i], newNums[i]);
			}
		}
		   ArrayList a1 = mb.showMyCart();
		    request.setAttribute("a1", a1);
			request.getRequestDispatcher("../Showcart/showcart.jsp").forward(request, response);
		}
		
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
